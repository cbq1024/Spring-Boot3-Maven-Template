package dev.cbq.user.vo.response;

import dev.cbq.base.BaseDataVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public final class RoleInfoVo extends BaseDataVo {
    private String roleName;
    private List<PermissionInfoVo> permissionInfoVos;
}
