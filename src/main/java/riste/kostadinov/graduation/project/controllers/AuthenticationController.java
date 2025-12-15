package riste.kostadinov.graduation.project.controllers;

import riste.kostadinov.graduation.project.domains.dtos.*;
import riste.kostadinov.graduation.project.exceptions.UserAlreadyExistException;
import riste.kostadinov.graduation.project.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign_in")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/sign_up")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        try{
            return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/sign_in_patient")
    public ResponseEntity<PatientAuthResponse> signInPatient(@RequestBody SignInRequest signInRequest) {
        return  ResponseEntity.ok(authenticationService.signInPatient(signInRequest));
    }

    @PostMapping("sign_up_patient")
    public ResponseEntity<PatientAuthResponse> signUpPatient(@RequestBody PatientRequest patientRequest) {
        try{
            return ResponseEntity.ok(authenticationService.signUpPatient(patientRequest));
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
