package com.rest.springrestapi.services;

import com.rest.springrestapi.api.v1.model.UserDto;
import com.rest.springrestapi.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getAllUser();
    UserDto getUserByName(String name);
    UserDto createNewUser(User user);
    UserDto getUserById(String id);


}
