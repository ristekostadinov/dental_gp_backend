package riste.kostadinov.graduation.project.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {
    public JwtTokenMissingException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
