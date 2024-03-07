package dima.senko.bookstore.service.user.impl;

import dima.senko.bookstore.dto.user.UserRegistrationRequestDto;
import dima.senko.bookstore.dto.user.UserResponseDto;
import dima.senko.bookstore.exception.RegistrationException;
import dima.senko.bookstore.mapper.UserMapper;
import dima.senko.bookstore.model.User;
import dima.senko.bookstore.repository.user.UserRepository;
import dima.senko.bookstore.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findUsersByEmail(requestDto.email()).isPresent()) {
            throw new RegistrationException("User with email " + requestDto.email()
                    + " already exists");
        }
        User user = userMapper.toModel(requestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
