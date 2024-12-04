package com.example.demo.controllers;

import com.example.demo.AbstractIntegrationTest;
import com.example.demo.domains.User;
import com.example.demo.domains.dtos.SignInRequest;
import com.example.demo.domains.dtos.SignUpRequest;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthenticationControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setup() {
        User user = new User();
        user.setUsername("testuserSignIn");
        user.setLastName("testuserSignIn");
        user.setFirstName("testuserSignIn");
        user.setPassword(passwordEncoder.encode("password")); // Encode the password
        user.setEmail("testuser1@example.com");
        userRepository.save(user);
    }

    @AfterEach
    void cleanup() {
        userRepository.deleteAll();
    }


    @Test
    void testSignUpEndpoint() throws Exception {
        SignUpRequest signUpRequest = new SignUpRequest(
                "testuser", "testuser", "testuser",
                "email@email.com", "password"
        );

        mockMvc.perform(post("/api/v1/auth/sign_up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testSignInEndpoint() throws Exception {
        SignInRequest signInRequest = new SignInRequest("testuser1@example.com", "password");

        mockMvc.perform(post("/api/v1/auth/sign_in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signInRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testLogOutEndpoint() throws Exception {
        SignInRequest request = new SignInRequest("testuser1@example.com", "password");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        mockMvc.perform(post("/api/v1/auth/logout").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
