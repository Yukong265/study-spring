package com.example.studyspring.domain.user.domain;


import com.example.studyspring.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 8, max = 15)
    @Column(unique = true)
    private String accountId;

    @Column
    @NotNull
    @Size(min =8, max = 60)
    private String password;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column
    private Authority authority;

    @Builder
    public User(Long id, String accountId, String password, String username, Authority authority){
        this.id = id;
        this.accountId = accountId;
        this.password = password;
        this.username = username;
        this.authority = authority;
    }
}
