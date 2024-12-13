package dev.cbq.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.cbq.user.model.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT * FROM role WHERE id IN (SELECT role_id FROM user_role_map WHERE user_id = #{userId})")
    Role selectByUserId(Long userId);
}