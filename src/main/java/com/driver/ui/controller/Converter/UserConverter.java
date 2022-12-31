package com.driver.ui.controller.Converter;

import com.driver.io.entity.UserEntity;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.UserResponse;
import com.driver.shared.dto.UserDto;

public class UserConverter {

    public static UserResponse dtoToResponse(UserDto userDto)
    {
        UserResponse userResponse = UserResponse.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .userId(userDto.getUserId())
                .build();
        return userResponse;
    }
}
