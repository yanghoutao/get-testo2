package com.hj.pas.utils;

import com.hftk.tools.exception.BizException;
import com.hj.pas.config.jwt.Jwtconfig;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class JwtTokenUtil {

  private static Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

  public static final String AUTH_HEADER_KEY = "Authorization";

  public static final String TOKEN_PREFIX = "Bearer";

  /**
   * 解析Jwt
   *
   * @param jsonWebToken
   * @param base64Security
   */
  public static Claims parseJWT(String jsonWebToken, String base64Security) {
    try {
      Claims claims =
          Jwts.parser()
              .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
              .parseClaimsJws(jsonWebToken)
              .getBody();
      return claims;
    } catch (ExpiredJwtException eje) {
      logger.error("===== Token过期 =====", eje);
      throw new BizException(400, "Token失效");
    } catch (Exception e) {
      logger.error("===== token解析异常 =====", e);
      throw new BizException(500, "token 解析异常");
    }
  }

  /**
   * 构建jwt
   *
   * @param userId
   * @param username
   * @param jwtConfig
   * @return
   */
  public static String createJWT(String userId, String username, Jwtconfig jwtConfig) {
    try {
      // 使用HS256加密算法
      SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

      long nowMillis = System.currentTimeMillis();
      Date now = new Date(nowMillis);

      // 生成签名密钥
      byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtConfig.getBase64Secret());
      Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

      // 添加构成JWT的参数
      JwtBuilder builder =
          Jwts.builder()
              .setHeaderParam("typ", "JWT")
              // 可以将基本不重要的对象信息放到claims
              .claim("userId", userId)
              .setSubject(username) // 代表这个JWT的主体，即它的所有人
              .setIssuer(jwtConfig.getClientId()) // 代表这个JWT的签发主体；
              .setIssuedAt(new Date()) // 是一个时间戳，代表这个JWT的签发时间；
              .setAudience(jwtConfig.getName()) // 代表这个JWT的接收对象；
              .signWith(signatureAlgorithm, signingKey);
      // 添加Token过期时间
      int TTLHours = jwtConfig.getExpiresHours();
      int TTLMillis = TTLHours * 60 * 60 * 1000;
      if (TTLMillis >= 0) {
        long expMillis = nowMillis + TTLMillis;
        Date exp = new Date(expMillis);
        builder
            .setExpiration(exp) // 是一个时间戳，代表这个JWT的过期时间；
            .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
      }

      // 生成JWT
      return builder.compact();
    } catch (Exception e) {
      logger.error("签名失败", e);
      throw new BizException(400,"签名失败");
    }
  }

  /**
   * 从token中获取用户名
   *
   * @param token
   * @param base64Security
   * @return
   */
  public static String getUsername(String token, String base64Security) {
    return parseJWT(token, base64Security).getSubject();
  }

  /**
   * 从token中获取用户ID
   *
   * @param token
   * @param base64Security
   * @return
   */
  public static String getUserId(String token, String base64Security) {
    String userId = parseJWT(token, base64Security).get("userId", String.class);
    return userId;
  }

  /**
   * 是否已过期
   *
   * @param token
   * @param base64Security
   * @return
   */
  public static boolean isExpiration(String token, String base64Security) {
    return parseJWT(token, base64Security).getExpiration().before(new Date());
  }

  /**
   * @return 加密的token
   * @throws NoSuchAlgorithmException
   */
  public static String getPassword(String phoneNo, String password)
      throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(phoneNo.concat(password).getBytes());
    return new BigInteger(1, md.digest()).toString();
  }

  /**
   * @param secret 用户的密码
   * @return 加密的token
   * @throws NoSuchAlgorithmException
   */
  public static Boolean verifyPassword(String phoneNo, String password, String secret)
      throws NoSuchAlgorithmException {
    return getPassword(phoneNo, password).equals(secret);
  }
}
