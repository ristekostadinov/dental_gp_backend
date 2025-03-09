package riste.kostadinov.graduation.project.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUsername(String token);
    String generateToken(UserDetails details);
    boolean isTokenValid(String token, UserDetails details);
}
