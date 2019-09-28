package com.rest.springrestapi.services;

import com.rest.springrestapi.api.v1.mapper.UserMapper;
import com.rest.springrestapi.api.v1.model.UserDto;
import com.rest.springrestapi.domain.User;
import com.rest.springrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserDto userDto=userMapper.userToUserDto(user);
                    userDto.setUserUrl("/api/v1/users/getUser/"+user.getId());
                    return userDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByName(String name) {
        return userMapper.userToUserDto(userRepository.findByName(name));
    }

    @Override
    public UserDto createNewUser(User user) {
        UserDto userDto=userMapper.userToUserDto(user);

        User savedUser =userRepository.save(user);

        userDto.setUserUrl("/api/v1/users/getUser/"+savedUser.getId());
        return userDto;
    }

    @Override
    public UserDto getUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDto).orElseThrow(ResourcesNotFoundException::new);//eğer sonunç dönmez ise geriye mesaj dondur
       }
}
