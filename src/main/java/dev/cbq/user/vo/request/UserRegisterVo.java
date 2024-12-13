package dev.cbq.user.vo.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public final class UserRegisterVo {
    private String username;
    @Email
    private String email;
    private String password;
}