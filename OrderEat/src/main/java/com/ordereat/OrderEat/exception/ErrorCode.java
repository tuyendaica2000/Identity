package com.ordereat.OrderEat.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User exist. --> User đã tồn tại.",HttpStatus.BAD_REQUEST ),
    SHIPPER_EXISTED(2001,"Shipper exist .--> Shipper đã tồn tại.",HttpStatus.BAD_REQUEST),
    RESTAURANT_EXISTED(3001,"Restaurant exist. --> Restaurant đã tồn tại.",HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized exception", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_INVALID(1003, "Username at least 5 character, please re-enter your username."+
            " --> Username chưa đủ 5 ký tự, vui lòng nhập lại username.",HttpStatus.BAD_REQUEST),
    NAME_INVALID(23003, "Name at least 5 character, please re-enter your name. " +
            "--> Name chưa đủ 5 ký tự, vui lòng nhập lại name.",HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least 8 character, please re-enter your password. " +
            "--> Password chưa đủ 8 ký tự, vui lòng nhập lại mật khẩu.",HttpStatus.BAD_REQUEST),
    PHONE_INVALID(2004,"Phone at least 8 character, please re-enter your phone." +
            " --> Số điện thoại chưa đủ 8 ký tự, vui lòng nhập lại số điện thoại.",HttpStatus.BAD_REQUEST),
    LOCATION_INVALID(3004,"Location at least 8 character, please re-enter your location."+
            " --> Location chưa đủ 5 ký tự, vui lòng nhập lại location.",HttpStatus.BAD_REQUEST),
    INVALID_KEY(4444, "Invalid message key",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007,"You do not have permission",HttpStatus.FORBIDDEN)
    ;


    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;


}
