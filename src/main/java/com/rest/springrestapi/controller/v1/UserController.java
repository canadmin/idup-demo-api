package com.rest.springrestapi.controller.v1;

import com.rest.springrestapi.api.v1.model.UserDto;
import com.rest.springrestapi.api.v1.model.UserListDto;
import com.rest.springrestapi.domain.User;
import com.rest.springrestapi.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(description = "User controller apisi")
@Controller
@RequestMapping("api/v1/users")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Tum kullanıcıları getiren servis")
    @GetMapping
    public ResponseEntity<UserListDto> getAllUser(){
        return new ResponseEntity<UserListDto>( new UserListDto(userService.getAllUser()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String name){
    return new ResponseEntity<UserDto>(userService.getUserByName(name),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserDto> createNewUser(@RequestBody User user){
        return new ResponseEntity<UserDto>(userService.createNewUser(user),HttpStatus.CREATED);
    }
    @GetMapping("getUser/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
    return  new ResponseEntity<UserDto>(userService.getUserById(userId),HttpStatus.OK);
    }
}
