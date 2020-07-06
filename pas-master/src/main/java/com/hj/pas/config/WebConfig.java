package com.hj.pas.config;

import com.hj.pas.config.jwt.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  /** 添加拦截器 */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 拦截路径可自行配置多个 可用 ，分隔开
    registry
        .addInterceptor(new JwtInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns(
            "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
  }

  /**
   * 跨域支持
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    WebMvcConfigurer.super.addCorsMappings(registry);
    registry
        .addMapping("/**")
        .allowedHeaders("*")
        .allowedMethods("POST", "GET")
        .allowedOrigins("*");
  }
}
