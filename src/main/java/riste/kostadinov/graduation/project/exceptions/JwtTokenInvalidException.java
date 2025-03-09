package riste.kostadinov.graduation.project.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenInvalidException extends AuthenticationException {
    public JwtTokenInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtTokenInvalidException(String msg) {
        super(msg);
    }
}
