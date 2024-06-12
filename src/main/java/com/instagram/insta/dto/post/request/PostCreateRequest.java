package com.instagram.insta.dto.post.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequest {
    private String context;
    private byte[] image;
    private LocalDateTime updateTime;
}
