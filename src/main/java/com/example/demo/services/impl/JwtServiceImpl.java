package com.example.demo.services.impl;

import com.example.demo.configuration.JwtProperties;
import com.example.demo.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {


    private final JwtProperties jwtProperties;
    private final ResourceLoader resourceLoader;

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public JwtServiceImpl(JwtProperties jwtProperties, ResourceLoader resourceLoader) {
        this.jwtProperties = jwtProperties;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void loadKey() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        Resource resource = resourceLoader.getResource("classpath:dental_gp.jks");
        if (!resource.exists()) {
            throw new FileNotFoundException("Keystore not found in classpath");
        }
            log.info("Keystore loaded successfully.");
        try (InputStream is = resource.getInputStream()) {
            keyStore.load(is, jwtProperties.getKeystorePassword().toCharArray());
            if (!keyStore.containsAlias(jwtProperties.getKeyAlias())) {
                throw new KeyStoreException("Key alias not found: " + jwtProperties.getKeyAlias());
            }
            privateKey = (PrivateKey) keyStore.getKey(jwtProperties.getKeyAlias(), jwtProperties.getKeyPassword().toCharArray());
            log.info("Private key loaded successfully.");

            publicKey = keyStore.getCertificate(jwtProperties.getKeyAlias()).getPublicKey();
            if (publicKey == null) {
                log.error("Public key is null for alias '{}'.", jwtProperties.getKeyAlias());
                throw new KeyStoreException("Public key is null for alias: " + jwtProperties.getKeyAlias());
            }
            log.info("Public key loaded successfully.");
        }
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails details) {
        return generateToken(new HashMap<>(), details);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails details) {
        final String username = extractUsername(token);
        return (username.equals(details.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        try {
            long expirationMills = jwtProperties.getExpiration();
            if (expirationMills <= 0) {
                throw new IllegalArgumentException("Expiration time must be greater than 0");
            }

            log.debug("Generating token for user: {}, expiration: {}", userDetails.getUsername(), expirationMills);

            return Jwts.builder()
                    .claims(extraClaims)
                    .subject(userDetails.getUsername())
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(Date.from(Instant.now().plusMillis(expirationMills)))
                    .signWith(privateKey)
                    .compact();
        } catch (Exception e) {
            log.error("Error generating JWT token: {}", e.getMessage(), e);
            throw new JwtException("Error while generating token");
        }
    }


    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(publicKey).build().parseSignedClaims(token).getPayload();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
