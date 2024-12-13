package dev.cbq.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import dev.cbq.user.model.User;

import java.util.Optional;

public interface UserService extends IService<User> {

    Optional<User> loadUserDetails(String username);



}
