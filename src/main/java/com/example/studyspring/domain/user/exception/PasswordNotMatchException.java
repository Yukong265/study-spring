package com.example.studyspring.domain.user.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class PasswordNotMatchException extends PostsException {
    public static final PasswordNotMatchException EXCEPTION =
            new PasswordNotMatchException();

    public PasswordNotMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
