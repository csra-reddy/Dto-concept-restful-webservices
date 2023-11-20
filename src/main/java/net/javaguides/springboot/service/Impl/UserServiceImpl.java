package net.javaguides.springboot.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto into User Jpa Entity as we will be saving user Jpa Entity object in to table/dn
        User user= UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        //Convert User JPA entity to UserDto
        UserDto savedUserDto=UserMapper.mapToUserDto(user);
        return savedUserDto;
    }
}
