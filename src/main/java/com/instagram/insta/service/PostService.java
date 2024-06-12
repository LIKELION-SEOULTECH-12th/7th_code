package com.instagram.insta.service;

import com.instagram.insta.domain.Post.Post;
import com.instagram.insta.domain.Post.PostRepository;
import com.instagram.insta.domain.User.User;
import com.instagram.insta.domain.User.UserRepository;
import com.instagram.insta.dto.post.request.PostCreateRequest;
import com.instagram.insta.dto.post.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final UserRepository userRepository;

    // 1. 사진, 글 업로드 -> 사진은 not null, 글은 null 가능
//    @Transactional
//    public void savePost(PostCreateRequest postCreateRequest) throws IOException {
//        Post post = new Post(
//                postCreateRequest.getImage().getBytes(),    // multipartfile to byte
//                postCreateRequest.getContext(),
//                postCreateRequest.getUploadTime(),
//                postCreateRequest.getUserId()
//        );
//        postRepository.save(post);
//    }
    @Transactional
    public PostResponse createPost(PostCreateRequest createRequest) throws IOException {
        System.out.println("Service run");
        if(createRequest.getUserId() == null){
            throw new IllegalArgumentException("User Id must not be null!!");
        }
        User user = userRepository.findById(createRequest.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Post post = new Post(createRequest.getContext(), createRequest.getImage().getBytes(), LocalDateTime.now(), user);
        Post savedPost = postRepository.save(post);
        return new PostResponse(savedPost.getId(), savedPost.getImage(), savedPost.getContext(), savedPost.getUploadTime(), savedPost.getUser().getId());
    }

    // 2. 전체 피드 보기
//    @Transactional
//    public List<PostResponse> getAllPost(){
//        List<Post> posts = postRepository.findAll();
//        return posts.stream().map(post -> new PostResponse(
//                post.getId(),
//                post.getImage(),
//                post.getContext(),
//                post.getUploadTime()
//        )).collect(Collectors.toList());
//    }
    @Transactional
    public List<PostResponse> getPostsByUserId(Long userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        return posts.stream().map(post -> new PostResponse(post.getId(), post.getImage(), post.getContext(), post.getUploadTime(), post.getUser().getId())).collect(Collectors.toList());
    }


//    // 3. 피드 하나씩 보기
//    public PostResponse readPost(Long postId){
//        Optional<Post> post = postRepository.findById(postId);
//        if (post.isPresent()){
//            Post post1 = post.get();
//            return new PostResponse(post1.getId(), post1.getImage(), post1.getContext(), post1.getUploadTime());
//        }else {
//            throw new IllegalArgumentException("Post Not Found");
//        }
//    }

}
