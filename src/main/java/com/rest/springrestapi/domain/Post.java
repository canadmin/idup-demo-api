package com.rest.springrestapi.domain;

import com.rest.springrestapi.api.v1.model.UserDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private String postType;
    private String postContent;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
