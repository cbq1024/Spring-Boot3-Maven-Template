package dev.cbq.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.cbq.user.mapper.PermissionMapper;
import dev.cbq.user.model.Permission;
import dev.cbq.user.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
