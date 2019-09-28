package com.rest.springrestapi.controller.v1;

import com.rest.springrestapi.api.v1.model.PostDto;
import com.rest.springrestapi.api.v1.model.PostListDto;
import com.rest.springrestapi.api.v1.model.UserDto;
import com.rest.springrestapi.api.v1.model.UserListDto;
import com.rest.springrestapi.domain.Post;
import com.rest.springrestapi.services.PostService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(description = "Post controller apisi")
@Controller
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<PostListDto> getAllPostByUserId(@PathVariable String userId){
        return new ResponseEntity<PostListDto>(new PostListDto(postService.getAllPostByUserId(userId)), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable String postId,@PathVariable String userId){
        return new ResponseEntity<PostDto>(postService.getPostByPostId(Integer.parseInt(postId),userId),HttpStatus.OK);
    }
}
