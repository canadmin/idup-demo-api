package com.rest.springrestapi.api.v1.mapper;

import com.rest.springrestapi.api.v1.model.UserDto;
import com.rest.springrestapi.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
