package com.rest.springrestapi.services;


import com.rest.springrestapi.api.v1.model.PostDto;
import com.rest.springrestapi.domain.Post;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPostByUserId(String userId);
    PostDto getPostByPostId(int postId,String userId);

}
