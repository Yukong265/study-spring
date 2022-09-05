package com.example.studyspring.domain.user.service;

import com.example.studyspring.domain.user.domain.User;
import com.example.studyspring.domain.user.domain.repository.UserRepository;
import com.example.studyspring.domain.user.exception.NotJoinedException;
import com.example.studyspring.domain.user.exception.PasswordNotMatchException;
import com.example.studyspring.domain.user.web.dto.request.SignInRequest;
import com.example.studyspring.domain.user.web.dto.response.TokenResponse;
import com.example.studyspring.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserSignInService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse signIn(SignInRequest request){
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> NotJoinedException.EXCEPTION);
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordNotMatchException.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refresh = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .authority(user.getAuthority())
                .build();
    }
}
