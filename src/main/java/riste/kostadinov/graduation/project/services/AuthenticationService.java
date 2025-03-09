package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.dtos.*;


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
