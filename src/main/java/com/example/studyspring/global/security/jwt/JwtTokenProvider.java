package com.example.studyspring.global.security.jwt;


import com.example.studyspring.domain.auth.domain.RefreshToken;
import com.example.studyspring.global.exception.InvalidJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.example.studyspring.global.security.auth.AuthDetailsService;
import com.example.studyspring.domain.auth.domain.repository.RefreshRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshRepository refreshRepository;

    public String generateAccessToken(String id){
        return generateToken(id, "access", jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String id) {
        String refreshToken = generateToken(id, "refresh", jwtProperties.getRefreshExp());

        refreshRepository.save(
                RefreshToken.builder()
                        .accountId(id)
                        .token(refreshToken)
                        .timeToLive(jwtProperties.getRefreshExp())
                        .build()
        );
        return refreshToken;
    }

    public String parseToken(String bearerToken){
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        }
        return null;
    }

    public String resolveToken(HttpServletRequest request){
        String bearer = request.getHeader(jwtProperties.getHeader());
        return parseToken(bearer);
    }

    private String generateToken(String id, String type, Long exp){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(id)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public Claims getTokenBody(String token){
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException error) {
            throw com.example.studyspring.global.exception.ExpiredJwtException.EXCEPTION;
        } catch (Exception error){
            throw InvalidJwtException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token){
        return getTokenBody(token).getSubject();
    }

    public Authentication authentication(String token){
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
