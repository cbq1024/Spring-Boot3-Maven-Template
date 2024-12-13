package dev.cbq.user.vo;

import dev.cbq.user.model.Role;
import dev.cbq.user.vo.response.RoleInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PermissionStruct.class)
public interface RoleStruct {

    RoleStruct INSTANCE = Mappers.getMapper(RoleStruct.class);

    @Mapping(target = "permissionInfoVos", expression = "java(PermissionStruct.INSTANCE.toInfoVo(role.getPermissions()))")
    RoleInfoVo toInfoVo(Role role);

}
