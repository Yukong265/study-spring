package com.example.studyspring.domain.user.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.ProjectException;

public class AlreadyJoinedException extends ProjectException {

    public static final ProjectException EXCEPTION =
            new AlreadyJoinedException();

    private AlreadyJoinedException() {
        super(ErrorCode.ALREADY_JOINED);
    }
}
