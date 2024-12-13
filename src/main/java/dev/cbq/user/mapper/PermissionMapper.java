package dev.cbq.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.cbq.user.model.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT * FROM permission WHERE id IN (SELECT permission_id  FROM role_permission_map WHERE role_id = #{roleId})")
    List<Permission> selectByRoleId(Integer roleId);
}