package com.instagram.insta.dto.post.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private long id;
    private byte[] image;
    private String context;
    private LocalDateTime uploadTime;

    public PostResponse(Long id, byte[] image, String context, LocalDateTime uploadTime) {
    }

    public long getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public String getContext() {
        return context;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }
}
