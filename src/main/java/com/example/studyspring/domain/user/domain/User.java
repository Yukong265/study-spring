package com.example.studyspring.domain.user.domain;


import com.example.studyspring.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String accounId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 8, nullable = false)
    private String username;

    @NotNull
    @Column
    private Authority authority;

    @Builder
    public User(Long id, String accounId, String password, String username, Authority authority){
        this.id = id;
        this.accounId = accounId;
        this.password = password;
        this.username = username;
        this.authority = authority;
    }
}
