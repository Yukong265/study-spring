package com.example.studyspring.domain.user.web.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    @NotBlank(message = "accountId는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 15, message = "accountId는 8자 이상, 15자 이하여야 합니다.")
    private String accountId;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String password;

    @NotBlank(message = "username은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String username;
}
