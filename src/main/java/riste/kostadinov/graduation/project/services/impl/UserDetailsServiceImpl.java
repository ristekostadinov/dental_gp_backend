package riste.kostadinov.graduation.project.services.impl;

import riste.kostadinov.graduation.project.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl {

    private final UserRepository repository;

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return repository.findByUsernameOrEmail(email, email).
                        orElseThrow(()->new UsernameNotFoundException("401"));
            }
        };
    }
}
