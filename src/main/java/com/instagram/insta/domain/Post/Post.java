package com.instagram.insta.domain.Post;

import com.instagram.insta.domain.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String context;

    @Column(columnDefinition = "LONGBLOB")
    @Lob
    private byte[] image;

    private LocalDateTime uploadTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;

    public Post(String context, byte[] image, LocalDateTime uploadTime, User user) {
        this.context = context;
        this.image = image;
        this.uploadTime = uploadTime;
        this.user = user;
    }
}
