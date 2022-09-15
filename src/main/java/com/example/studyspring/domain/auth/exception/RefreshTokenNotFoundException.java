package com.example.studyspring.domain.auth.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.ProjectException;

public class RefreshTokenNotFoundException extends ProjectException {
    public static final RefreshTokenNotFoundException EXCEPTION =
            new RefreshTokenNotFoundException();

    public RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_NOT_FOUND);
    }
}
