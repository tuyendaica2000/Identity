package com.ordereat.OrderEat.controller;

import com.nimbusds.jose.JOSEException;
import com.ordereat.OrderEat.dto.request.ApiResponse;
import com.ordereat.OrderEat.dto.request.AuthenticationRequest;
import com.ordereat.OrderEat.dto.request.IntrospectRequest;
import com.ordereat.OrderEat.dto.response.AuthenticationResponse;
import com.ordereat.OrderEat.dto.response.IntrospectResponse;
import com.ordereat.OrderEat.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build()
    ;}

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {

        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build()
                ;}
}
