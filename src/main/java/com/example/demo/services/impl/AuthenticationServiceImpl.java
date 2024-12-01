package com.example.demo.services.impl;
import com.example.demo.domains.User;
import com.example.demo.domains.dtos.*;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.JwtService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        var user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRoles(new HashSet<>());
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponse(jwt,
                user.getUsername(),
                user.getEmail(),
                user.getRoles()
        );
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        var user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));
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
        var user = userRepository.findByEmail(email);
    }
}
