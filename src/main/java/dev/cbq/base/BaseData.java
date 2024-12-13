package dev.cbq.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseData implements Serializable {
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    LocalDateTime updateTime;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @Version
    Integer version;

    /**
     * 软删除字段 [ 1 已删除 | 0 未删除 ]
     */
    @TableField(value = "deleted")
    @TableLogic
    Integer deleted;
}
