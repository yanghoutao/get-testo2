package com.hj.pas.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwtconfig")
@Getter
@Setter
public class Jwtconfig {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresHours;

}