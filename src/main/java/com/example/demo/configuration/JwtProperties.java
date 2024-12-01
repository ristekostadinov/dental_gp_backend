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
    
    private String keystorePath;

    private String keystorePassword;

    private String keyAlias;

    private String keyPassword;
}
