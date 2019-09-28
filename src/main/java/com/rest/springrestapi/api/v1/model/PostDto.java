package com.rest.springrestapi.api.v1.model;

import com.rest.springrestapi.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostDto {

    private int postId;
    private String postType;
    private String postContent;
    @ApiModelProperty(value = "Bu Alan user parametresinin tipi: User sınıfı",required = true)
    private User user;

}
