package dima.senko.bookstore.service.user;

import dima.senko.bookstore.dto.user.UserRegistrationRequestDto;
import dima.senko.bookstore.dto.user.UserResponseDto;
import dima.senko.bookstore.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}
