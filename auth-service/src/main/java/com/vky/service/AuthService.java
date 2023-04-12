package com.vky.service;

import com.vky.config.security.JwtTokenManager;
import com.vky.dto.request.DoLoginRequestDto;
import com.vky.dto.request.NewUserCreateDto;
import com.vky.dto.request.RegisterRequestDto;
import com.vky.exception.AuthManagerException;
import com.vky.exception.ErrorType;
import com.vky.manager.IUserManager;
import com.vky.rabbitmq.model.CreateUser;
import com.vky.rabbitmq.producer.CreateUserProducer;
import com.vky.repository.IAuthRepository;
import com.vky.repository.entity.Auth;
import com.vky.repository.enums.Roles;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {
    private final IAuthRepository authRepository;
    private final IUserManager userManager;
    private final CreateUserProducer createUserProducer;
    private final JwtTokenManager jwtTokenManager;

    public AuthService(IAuthRepository authRepository,IUserManager userManager, CreateUserProducer createUserProducer, JwtTokenManager jwtTokenManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
        this.createUserProducer = createUserProducer;
        this.jwtTokenManager = jwtTokenManager;
    }


    public Optional<Auth> doLogin(DoLoginRequestDto loginDto)
    {
        String encodedPassword = jwtTokenManager.encryptPassword(loginDto.getPassword());
        return authRepository.findOptionalByUserNameIgnoreCaseAndPassword(loginDto.getUserName(), encodedPassword);
    }

    public Auth register(RegisterRequestDto registerDto)
    {
        String encodedPassword = jwtTokenManager.encryptPassword(registerDto.getPassword());
        Boolean isExist = authRepository.isExistsUserName(registerDto.getUserName());
        if(isExist) throw new AuthManagerException(ErrorType.LOGIN_ERROR_USERNAME_DUPLICATE);
        Auth auth;
            auth = Auth.builder()
                    .userName(registerDto.getUserName())
                    .password(encodedPassword)
                    .role(Roles.USER)
                    .build();
            if(registerDto.getRoleAdminPassword() != null)
            {
                if(registerDto.getRoleAdminPassword().equals("123456"))
                {
                    auth.setRole(registerDto.getRole() == null ? Roles.ADMIN : registerDto.getRole());
                }
                else {
                    auth.setRole(Roles.USER);
                }
            }
        //User service e kullanicinin profilini olusturmasi icin istek gonderiri
        save(auth);
//        userManager.newUserCreate(
//                NewUserCreateDto.builder()
//                        .authid(auth.getId())
//                        .email(registerDto.getEmail())
//                        .userName(registerDto.getUserName())
//                        .build()
//        );
        createUserProducer.sendCreateUserMessage(CreateUser.builder()
                .authid(auth.getId())
                .email(registerDto.getEmail())
                .userName(auth.getUserName())
                .password(encodedPassword)
                .build());
        return auth;
    }
}
