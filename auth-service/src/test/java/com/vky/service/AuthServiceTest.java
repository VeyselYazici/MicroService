package com.vky.service;

import com.vky.dto.request.DoLoginRequestDto;
import com.vky.dto.request.RegisterRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {
    @Autowired
    AuthService authService;
    @Test
    public void registerTest()
    {
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                        .userName("veysel")
                        .password("1")
                        .email("123")
                        .build();
        Assertions.assertEquals(authService.register(registerRequestDto).getUserName(),"veysel");
    }
    @Test
    public void registerTest2()
    {
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                .userName("veysel")
                .password("1")
                .RoleAdminPassword("123456")
                .email("123")
                .build();
        Assertions.assertEquals(authService.register(registerRequestDto).getUserName(),"veysel");
    }
    @Test
    public void registerTest3()
    {
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                .userName("veysel")
                .password("1")
                .RoleAdminPassword("asdfasdf123dfadsf1")
                .email("123")
                .build();
        Assertions.assertEquals(authService.register(registerRequestDto).getUserName(),"veysel");
    }

    @Test
    public void doLoginTest()
    {

    }
}
