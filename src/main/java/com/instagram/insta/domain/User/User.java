package com.instagram.insta.domain.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(length = 20, nullable = false)
    private String Nickname;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;
}