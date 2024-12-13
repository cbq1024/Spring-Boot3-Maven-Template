package dev.cbq.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import dev.cbq.base.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User extends BaseData implements Serializable {

    /**
     * 主键 ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "`username`")
    private String username;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 角色
     */
    @TableField(exist = false)
    private Role role;

    @Serial
    private static final long serialVersionUID = 1L;
}