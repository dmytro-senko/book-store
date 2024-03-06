package dima.senko.bookstore.mapper;

import dima.senko.bookstore.config.MapperConfig;
import dima.senko.bookstore.dto.user.UserRegistrationRequestDto;
import dima.senko.bookstore.dto.user.UserResponseDto;
import dima.senko.bookstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toUserResponse(User user);

    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);
}
