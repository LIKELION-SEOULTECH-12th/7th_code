package com.instagram.insta.dto.post.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private long id;
    private byte[] image;
    private String context;
    private LocalDateTime uploadTime;
    private Long userId;
}
