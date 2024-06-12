package com.instagram.insta.domain.Post;

import com.instagram.insta.domain.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 255)
    private String Context;

    @Column(nullable = false, columnDefinition = "LONGBLOB")
    @Lob
    private byte[] Image;

    private LocalDateTime uploadTime;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;


    public Post(byte[] image, String context, LocalDateTime updateTime) {
    }
}
