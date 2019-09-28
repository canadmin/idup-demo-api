package com.rest.springrestapi.services;

import com.rest.springrestapi.api.v1.mapper.PostMapper;
import com.rest.springrestapi.api.v1.model.PostDto;
import com.rest.springrestapi.domain.Post;
import com.rest.springrestapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostMapper postMapper, PostRepository postRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> getAllPostByUserId(String userId) {
        return postRepository.getAllPostByUserId(userId)
                .stream()
                .map(postMapper::postToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByPostId(int postId,String userId) {
        return postMapper.postToPostDto(postRepository.getPostByPostIdAndUserId(postId,userId));
    }
}
