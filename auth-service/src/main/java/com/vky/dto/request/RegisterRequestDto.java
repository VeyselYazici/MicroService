package com.vky.dto.request;

import com.vky.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Kullanici adi en az 3 karakter ve en fazla 20 karakter olabilir")
    String userName;
    @NotNull
    String password;
    @NotNull
    @Email(message = "Email formati uygun degil")
    String email;
    Roles role;
    String RoleAdminPassword;
}
