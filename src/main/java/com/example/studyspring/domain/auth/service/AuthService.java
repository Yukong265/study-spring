package com.example.studyspring.domain.auth.service;


import com.example.studyspring.domain.auth.domain.RefreshToken;
import com.example.studyspring.domain.auth.domain.repository.RefreshRepository;
import com.example.studyspring.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.studyspring.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.studyspring.domain.user.domain.User;
import com.example.studyspring.domain.user.facade.UserFacade;
import com.example.studyspring.global.exception.InvalidJwtException;
import com.example.studyspring.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService {
    private final RefreshRepository refreshRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserFacade userFacade;

    @Transactional
    public UserRefreshTokenResponse reissue(String refreshToken) {
        User user = userFacade.getCurrentUser();

        if (!jwtTokenProvider.getTokenBody(refreshToken).get("type").equals("refresh"))
            throw InvalidJwtException.EXCEPTION;


        RefreshToken refreshTokenOne = refreshRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(refreshTokenOne.getAccountId());
        refreshTokenOne.updateToken(newRefreshToken);

        String accessToken = jwtTokenProvider.generateAccessToken(refreshTokenOne.getAccountId());

        return UserRefreshTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .authority(user.getAuthority())
                .build();
    }
}
