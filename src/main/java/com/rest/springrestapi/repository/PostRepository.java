package com.rest.springrestapi.repository;

import com.rest.springrestapi.api.v1.model.PostDto;
import com.rest.springrestapi.domain.Post;
import com.rest.springrestapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> getAllPostByUserId(String userId);
    Post getPostByPostIdAndUserId(int postId,String userId);

}
