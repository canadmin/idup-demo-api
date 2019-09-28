package com.rest.springrestapi.api;

import com.rest.springrestapi.api.v1.mapper.UserMapper;
import com.rest.springrestapi.api.v1.model.UserDto;
import com.rest.springrestapi.domain.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserMapperTest {
        /*
            private String name;
    private String email;
    private String password;
    private String type;*/

    private static final String NAME ="Can";
    private static final String MAIL ="canyard@gmail.com";
    private static final String TYPE ="Investment";

    UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void userToUserDTO() throws Exception{
        User user = new User();
        user.setEmail(NAME);
        user.setType(MAIL);
        user.setType(TYPE);

        UserDto userDto=userMapper.userToUserDto(user);

        assertEquals(user.getName(),userDto.getName());
    }

}
