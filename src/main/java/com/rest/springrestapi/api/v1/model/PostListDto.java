package com.rest.springrestapi.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostListDto {
    List<PostDto> posts;
}
