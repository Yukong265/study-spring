package com.example.studyspring.domain.user.web;


import com.example.studyspring.domain.user.service.UserSignUpService;
import com.example.studyspring.domain.user.web.dto.request.SignInRequest;
import com.example.studyspring.domain.user.web.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest request){
        userSignUpService.signup(request);
    }

    @PostMapping("/signin")
    public void signin(@RequestBody @Valid SignInRequest request){

    }

    @PutMapping
    public void modifiyUser(@RequestBody @Valid )
}
