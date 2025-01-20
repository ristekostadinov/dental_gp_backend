package com.example.demo.services.impl;
import com.example.demo.domains.dtos.*;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.JwtService;
import com.example.demo.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    @Transactional
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        log.debug("Processing sign-up request: {}", request);
        try {
            log.debug("Saving user to the database from request: {}", request);
            var savedUser = userService.create(request);

            log.debug("Generating JWT for user: {}", savedUser);
            var jwt = jwtService.generateToken(savedUser);

            log.debug("Returning response with JWT: {}", jwt);
            return new JwtAuthenticationResponse(jwt,
                    savedUser.getUsername(),
                    savedUser.getEmail(),
                    savedUser.getRoles()
            );
        } catch (Exception e) {
            log.error("Error during sign-up process: {}", e.getStackTrace(), e);
            throw e;
        }
    }


    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var user = userService.findByEmail(request.email());
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt,
                user.getUsername(),
                user.getEmail(),
                user.getRoles());
    }

    @Override
    public Boolean forgot(ForgotRequest request) {
        return null;
    }

    @Override
    public UserDTO changePassword(ChangePasswordRequest request) {
        return null;
    }

    @Override
    public Boolean activate(String code, SetUpPasswordRequest request) {
        return null;
    }

    @Override
    public void reset(Long id) {

    }

    @Override
    public UserDTO changeStatus(Long id) {
        return null;
    }

    @Override
    public void resendActivationEmail(String email) {
    }
}
