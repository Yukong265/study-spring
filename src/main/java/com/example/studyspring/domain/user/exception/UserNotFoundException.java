package com.example.studyspring.domain.user.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class UserNotFoundException extends PostsException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException(){
        super(ErrorCode.USER_NOTFOUND);
    }
}
