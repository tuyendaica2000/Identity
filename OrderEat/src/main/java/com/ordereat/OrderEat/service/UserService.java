package com.ordereat.OrderEat.service;

import com.ordereat.OrderEat.dto.request.UserCreationRequest;
import com.ordereat.OrderEat.dto.request.UserUpdateRequest;
import com.ordereat.OrderEat.dto.response.UserResponse;
import com.ordereat.OrderEat.entity.User;
import com.ordereat.OrderEat.enums.Role;
import com.ordereat.OrderEat.exception.AppException;
import com.ordereat.OrderEat.exception.ErrorCode;
import com.ordereat.OrderEat.mapper.UserMapper;
import com.ordereat.OrderEat.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    // tạo user mới.
    public User createUser(UserCreationRequest request) {
        // Điều kiện nếu đã tạo user r mà vẫn tạo giống hệt tên user cũ thì báo lỗi.
        if (userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());

        user.setRoles(String.valueOf(roles));

        return userRepository.save(user) ;
    }
    //method để giúp lấy ra danh sách user đã tạo
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //method lấy ra thông tin user thông qua /userId
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(Long id) {
        log.info("In method get user by Id");
        return userMapper.toUserResponse( userRepository.findById(id).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    //GET ra thông tin của riêng user đó khi có token
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    //Update thông tin của user
    public UserResponse updateUser(Long userId ,UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new RuntimeException("User not found. --> Không tìm thấy user || user không tồn tại."));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse( userRepository.save(user));
    }

    // Xóa user sẽ không cần kiểu trả về nên sẽ dùng luôn void cho tiện
    public void deleteUser(Long userId) {
         userRepository.deleteById(userId);
    }
}
