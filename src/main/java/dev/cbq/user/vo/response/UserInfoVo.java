package dev.cbq.user.vo.response;

import dev.cbq.base.BaseDataVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class UserInfoVo extends BaseDataVo {
    private String username;
    private Integer age;
    private String email;
    private String avatar;
    private RoleInfoVo roleInfoVo;
}
