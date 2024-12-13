package dev.cbq.user.vo;

import dev.cbq.user.model.Permission;
import dev.cbq.user.vo.response.PermissionInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface PermissionStruct {

    PermissionStruct INSTANCE = Mappers.getMapper(PermissionStruct.class);

    List<PermissionInfoVo> toInfoVo(List<Permission> permissions);

}
