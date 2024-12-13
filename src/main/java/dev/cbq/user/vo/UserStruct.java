package dev.cbq.user.vo;

import dev.cbq.user.model.User;
import dev.cbq.user.vo.response.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = RoleStruct.class)
public interface UserStruct {

    UserStruct INSTANCE = Mappers.getMapper(UserStruct.class);

    @Mapping(target = "roleInfoVo", expression = "java(RoleStruct.INSTANCE.toInfoVo(user.getRole()))")
    UserInfoVo toInfoVo(User user);

}
