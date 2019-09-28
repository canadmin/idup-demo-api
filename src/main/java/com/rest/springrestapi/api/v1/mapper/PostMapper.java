package com.rest.springrestapi.api.v1.mapper;

import com.rest.springrestapi.domain.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.rest.springrestapi.api.v1.model.PostDto;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE= Mappers.getMapper(PostMapper.class);

    @Mapping(source = "postId",target = "postId")
    PostDto postToPostDto(Post post);

}
