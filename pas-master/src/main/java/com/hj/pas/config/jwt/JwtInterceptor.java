package com.hj.pas.config.jwt;

import com.hftk.tools.exception.BizException;
import com.hftk.tools.http.ResultCodeEnum;
import com.hj.pas.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private Jwtconfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }
        String method = request.getMethod();
        if (HttpMethod.OPTIONS.toString().equals(method)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头信息authorization信息
        final String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        log.info("===== authHeader:" + authHeader);

        if (StringUtils.isBlank(authHeader)) {
            log.info("=====用户未登录，请先登录=====");
            throw new BizException(ResultCodeEnum.USER_NOT_LOGINORREGISTER);
        }

        if (jwtConfig == null) {
            BeanFactory factory =
                WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            jwtConfig = (Jwtconfig)factory.getBean("jwtconfig");
        }

        JwtTokenUtil.parseJWT(authHeader, jwtConfig.getBase64Secret());

        return true;
    }

}
