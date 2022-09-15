package com.example.studyspring.domain.posts.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.ProjectException;

public class ProjectNotFoundException extends ProjectException {
    public static final ProjectException EXCEPTION = new ProjectNotFoundException();

    private ProjectNotFoundException() {
        super(ErrorCode.POST_NOTFOUND);
    }
}
