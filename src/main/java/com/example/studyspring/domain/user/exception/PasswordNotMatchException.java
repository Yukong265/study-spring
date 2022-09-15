package com.example.studyspring.domain.user.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.ProjectException;

public class PasswordNotMatchException extends ProjectException {
    public static final PasswordNotMatchException EXCEPTION =
            new PasswordNotMatchException();

    public PasswordNotMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
