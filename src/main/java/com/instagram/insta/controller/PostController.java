package com.instagram.insta.controller;

import com.instagram.insta.dto.post.request.PostCreateRequest;
import com.instagram.insta.dto.post.response.PostResponse;
import com.instagram.insta.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/insta")
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 피드 업로드
    @GetMapping("/upload")
    public void savePost(@RequestBody PostCreateRequest postCreateRequest){
        postService.savePost(postCreateRequest);
    }

    // 전체 피드 조회
    @GetMapping("/{nickname}")
    private List<PostResponse> getAllPost(@PathVariable String nickname){
        return postService.getAllPost();
    }

    // 개별 피드 조회
    @GetMapping("/{postId}")
    private PostResponse getPost(@PathVariable Long postId){
        return postService.readPost(postId);
    }

}
