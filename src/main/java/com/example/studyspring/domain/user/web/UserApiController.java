package com.example.studyspring.domain.user.web;


import com.example.studyspring.domain.user.service.UserSignInService;
import com.example.studyspring.domain.user.service.UserSignUpService;
import com.example.studyspring.domain.user.web.dto.request.SignInRequest;
import com.example.studyspring.domain.user.web.dto.request.SignUpRequest;
import com.example.studyspring.domain.user.web.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserSignUpService userSignUpService;

    private final UserSignInService userSignInService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest request) {
        userSignUpService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return userSignInService.signIn(request);
    }
}