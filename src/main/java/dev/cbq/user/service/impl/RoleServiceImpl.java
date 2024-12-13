package dev.cbq.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.cbq.user.mapper.RoleMapper;
import dev.cbq.user.model.Role;
import dev.cbq.user.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
