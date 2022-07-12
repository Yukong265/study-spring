package com.example.studyspring.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    POST_NOTFOUND(404, "POST-404-1", "Posts Not Found"),


    USER_NOTFOUND(404, "USER-404-1", "User Not Found"),

    ALREADY_JOINED(409, "USER-409-1", "User Already Joined");

    private final int status;
    private final String code;
    private final String message;
}
