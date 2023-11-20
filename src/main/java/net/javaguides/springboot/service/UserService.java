package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;

public interface UserService {

    UserDto createUser(UserDto user);
}
