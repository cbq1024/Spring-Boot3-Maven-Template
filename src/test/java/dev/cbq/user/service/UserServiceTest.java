package dev.cbq.user.service;

import dev.cbq.user.model.User;
import dev.cbq.user.vo.PermissionStruct;
import dev.cbq.user.vo.RoleStruct;
import dev.cbq.user.vo.UserStruct;
import dev.cbq.user.vo.response.PermissionInfoVo;
import dev.cbq.user.vo.response.RoleInfoVo;
import dev.cbq.user.vo.response.UserInfoVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;
    private User user;

    @BeforeEach
    void setUp() {
        user = service.loadUserDetails("mcdd1024").orElseThrow(() -> new RuntimeException("user not found"));
        assertNotNull(user,"user is null");
    }

    @Test
    void should_translate_user_successful_from_user_to_userInfo() {
        //given
        UserInfoVo userInfoVo = UserStruct.INSTANCE.toInfoVo(user);
        assertNotNull(userInfoVo, "userInfoVo is null");
        System.out.println("user = " + user);
        System.out.println("userInfoVo = " + userInfoVo);
    }

    @Test
    void should_translate_permission_successful_from_permission_to_permissionInfo() {
        //given
        List<PermissionInfoVo> permissionInfoVos = PermissionStruct.INSTANCE.toInfoVo(user.getRole().getPermissions());
        System.out.println("permissionInfoVos = " + permissionInfoVos);
    }

    @Test
    void should_translate_roleInfoVo_successful_from_role() {
        //given
        RoleInfoVo infoVo = RoleStruct.INSTANCE.toInfoVo(user.getRole());
        System.out.println("infoVo = " + infoVo);
    }

}