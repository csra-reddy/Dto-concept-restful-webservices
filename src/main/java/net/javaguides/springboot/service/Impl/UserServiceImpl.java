package net.javaguides.springboot.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
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
        User user=new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        User savedUser = userRepository.save(user);

        //Convert User JPA entity to UserDto
        UserDto savedUserDto=new UserDto();
        savedUserDto.setId(savedUser.getId());
        savedUserDto.setFirstName(savedUser.getFirstName());
        savedUserDto.setLastName(savedUser.getLastName());
        savedUserDto.setEmail(savedUser.getEmail());
        return savedUserDto;
    }
}
