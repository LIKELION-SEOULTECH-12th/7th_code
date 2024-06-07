package com.instagram.insta.domain.User;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(length = 20, nullable = false)
    private String NickName;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;

}
