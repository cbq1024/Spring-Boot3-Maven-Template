package dev.cbq.user.vo.response;

import dev.cbq.base.BaseDataVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public final class UserAuthDetailsVo extends BaseDataVo {
    private UserInfoVo userInfoVo;
    private RoleInfoVo roleInfoVo;
    private List<PermissionInfoVo> permissionInfoVos;
}
