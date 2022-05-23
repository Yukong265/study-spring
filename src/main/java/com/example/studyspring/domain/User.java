package com.example.studyspring.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column 
    private Integer age;

    @Builder
    public User(String name, String password, Integer age){
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
