package com.instagram.insta.service;

import com.instagram.insta.domain.Post.Post;
import com.instagram.insta.domain.Post.PostRepository;
import com.instagram.insta.dto.post.request.PostCreateRequest;
import com.instagram.insta.dto.post.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 1. 사진, 글 업로드 -> 사진은 not null, 글은 null 가능
    @Transactional
    public void savePost(PostCreateRequest postCreateRequest){
        postRepository.save(new Post(postCreateRequest.getImage(), postCreateRequest.getContext(), postCreateRequest.getUpdateTime()));
    }

    // 2. 전체 피드 보기
    @Transactional
    public List<PostResponse> getAllPost(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostResponse(
                post.getId(),
                post.getImage(),
                post.getContext(),
                post.getUploadTime()
        )).collect(Collectors.toList());
    }

    // 3. 피드 하나씩 보기
    public PostResponse readPost(Long postId){
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            Post post1 = post.get();
            return new PostResponse(post1.getId(), post1.getImage(), post1.getContext(), post1.getUploadTime());
        }else {
            throw new IllegalArgumentException("Post Not Found");
        }
    }

}
