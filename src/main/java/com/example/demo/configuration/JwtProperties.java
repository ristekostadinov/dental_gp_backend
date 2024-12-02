package com.example.demo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix= "jwt")
@Getter
@Setter
public class JwtProperties {
    @Value("${jwt.keystore.path}")
    private String keystorePath;
    @Value("${jwt.keystore.password}")
    private String keystorePassword;
    @Value("${jwt.key.alias}")
    private String keyAlias;
    @Value("${jwt.key.password}")
    private String keyPassword;
}
