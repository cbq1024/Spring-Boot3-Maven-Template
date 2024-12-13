package dev.cbq.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.cbq.user.mapper.PermissionMapper;
import dev.cbq.user.mapper.RoleMapper;
import dev.cbq.user.mapper.UserMapper;
import dev.cbq.user.model.Permission;
import dev.cbq.user.model.Role;
import dev.cbq.user.model.User;
import dev.cbq.user.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper mapper;
    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;

    public UserServiceImpl(UserMapper mapper, RoleMapper roleMapper, PermissionMapper permissionMapper) {
        this.mapper = mapper;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public Optional<User> loadUserDetails(String username) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, username);
        User user = mapper.selectOne(userLambdaQueryWrapper);
        if (user == null) {
            return Optional.empty();
        }
        Long id = user.getId();
        Role role = roleMapper.selectByUserId(id);
        if (role == null) {
            return Optional.empty();
        }
        Integer roleId = role.getId();
        List<Permission> permissions = permissionMapper.selectByRoleId(roleId);
        if (permissions == null) {
            return Optional.empty();
        }
        role.setPermissions(permissions);
        user.setRole(role);

        return Optional.of(user);
    }

}
