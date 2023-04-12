package com.vky.controller;

import com.vky.dto.request.DoLoginRequestDto;
import com.vky.dto.request.RegisterRequestDto;
import com.vky.dto.response.DoLoginResponseDto;
import com.vky.rabbitmq.producer.CreateUserProducer;
import com.vky.repository.entity.Auth;
import com.vky.service.AuthService;
import com.vky.config.security.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static com.vky.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;


    @GetMapping("/test")
    @CrossOrigin(originPatterns = "*")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public String getTestString()
    {
        return "Auth test";
    }

    @PostMapping(LOGIN)
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto loginDto)
    {
        Optional<Auth> auth = authService.doLogin(loginDto);
        if(auth.isPresent())
        {
            String token = jwtTokenManager.createToken(auth.get().getId()).get();
            return ResponseEntity.ok(DoLoginResponseDto
                    .builder()
                    .token(token)
                    .message("Login Successful")
                    .responsecode(200L)
                    .build());
        }
        return ResponseEntity.ok(DoLoginResponseDto
                .builder()
                .message("Login failed")
                .responsecode(400L)
                .build());
    }

    @PostMapping(REGISTER)
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto registerDto)
    {
        authService.register(registerDto);
        return ResponseEntity.ok().build();
    }

}
