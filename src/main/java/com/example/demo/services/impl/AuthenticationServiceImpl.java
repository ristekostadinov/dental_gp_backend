package com.example.demo.services.impl;

import com.example.demo.domains.dtos.*;
import com.example.demo.services.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        return null;
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        return null;
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
