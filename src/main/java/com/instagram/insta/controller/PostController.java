package com.instagram.insta.controller;

import com.instagram.insta.dto.post.request.PostCreateRequest;
import com.instagram.insta.dto.post.response.PostResponse;
import com.instagram.insta.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/insta")
@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    // 피드 업로드
//    @PostMapping("/upload")
//    public void savePost(@RequestParam("context")String context,
//                         @RequestPart("image") MultipartFile image,
////                         @RequestPart("upload_time") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime uploadTime,
//                         @RequestParam("upload_time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime uploadTime,
//                         @RequestParam("user_id") Long userId) throws IOException {
//        PostCreateRequest postCreateRequest = new PostCreateRequest(context, image, uploadTime, userId);
//        postService.savePost(postCreateRequest);
//    }
    @PostMapping("/upload")
    public PostResponse createPost(
            @RequestParam("image") MultipartFile image,
            @RequestParam("context") String context,
            @RequestParam("userId") Long userId) throws IOException {
        System.out.println("Received User ID: " + userId); // 로그 추가
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setImage(image);
        createRequest.setContext(context);
        createRequest.setUserId(userId);
        return postService.createPost(createRequest);
    }
//    public PostResponse createPost(PostCreateRequest createRequest) throws IOException {
//        System.out.println("controller run");
//        System.out.println("Received User Id: " + createRequest.getUserId());
//        return postService.createPost(createRequest);
//    }

    // 전체 피드 조회
    @GetMapping("/{userId}")
    private List<PostResponse> getPostsByUserId(@PathVariable Long userId){
        return postService.getPostsByUserId(userId);
    }

//    // 개별 피드 조회
//    @GetMapping("/{postId}")
//    private PostResponse getPost(@PathVariable Long postId){
//        return postService.readPost(postId);
//    }

}
