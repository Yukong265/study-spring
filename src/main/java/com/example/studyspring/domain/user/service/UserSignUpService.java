package com.example.studyspring.domain.user.service;


import com.example.studyspring.domain.user.domain.User;
import com.example.studyspring.domain.user.domain.repository.UserRepository;
import com.example.studyspring.domain.user.exception.AlreadyJoinedException;
import com.example.studyspring.domain.user.web.dto.request.SignUpRequest;
import com.example.studyspring.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserSignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignUpRequest request){
        if(userRepository.findByAccounId(request.getAccountId()).isPresent())
            throw AlreadyJoinedException.EXCEPTION;

        userRepository.save(
                User.builder()
                        .accounId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .username(request.getUsername())
                        .authority(Authority.USER)
                        .build()
        );
    }
}
