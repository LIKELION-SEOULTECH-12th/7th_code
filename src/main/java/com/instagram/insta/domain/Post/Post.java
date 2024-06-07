package com.instagram.insta.domain.Post;

import com.instagram.insta.domain.User.User;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 255)
    private String Context;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
}
