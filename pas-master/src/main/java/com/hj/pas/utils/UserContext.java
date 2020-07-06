package com.hj.pas.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNameUserContext
 * @Author QiXueQing
 * @Date 2020/6/24
 * @Version V1.0
 **/
@Component
public class UserContext {
  private static String base64Secret;

  @Value("${jwtconfig.base64Secret}")
  public void setBase64Secret(String base64Secret) {
    this.base64Secret = base64Secret;
  }

  public static String getUserId() {
    HttpServletRequest req =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String token = req.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
    // 然后根据token获取用户登录信息，这里省略获取用户信息的过程，随便填写一些数据
    String userId = JwtTokenUtil.getUserId(token, base64Secret);
    return userId;
  }
}
