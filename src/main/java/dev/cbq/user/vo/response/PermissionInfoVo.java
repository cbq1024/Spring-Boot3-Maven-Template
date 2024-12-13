package dev.cbq.user.vo.response;

import dev.cbq.base.BaseDataVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class PermissionInfoVo extends BaseDataVo {
    private String permissionName;
}
