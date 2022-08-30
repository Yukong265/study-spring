package com.example.studyspring.domain.user.web.dto.response;

import com.example.studyspring.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
