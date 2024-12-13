package dev.cbq.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.cbq.user.model.User;

public interface UserMapper extends BaseMapper<User> {

    User selectUserByUserName(String username);

}