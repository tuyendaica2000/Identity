package com.ordereat.OrderEat.mapper;

import com.ordereat.OrderEat.dto.request.UserCreationRequest;
import com.ordereat.OrderEat.dto.request.UserUpdateRequest;
import com.ordereat.OrderEat.dto.response.UserResponse;
import com.ordereat.OrderEat.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}

