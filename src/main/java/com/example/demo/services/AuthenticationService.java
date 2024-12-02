package com.example.demo.services;

import com.example.demo.domains.dtos.*;
import org.springframework.stereotype.Component;


public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);

    Boolean forgot(ForgotRequest request);

    UserDTO changePassword(ChangePasswordRequest request);

    Boolean activate(String code, SetUpPasswordRequest request);

    void reset(Long id);

    UserDTO changeStatus(Long id);

    void resendActivationEmail(String email);
}
