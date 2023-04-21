package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("admin_info")
public class AdminInfo {

    @TableId("admin_id")
    private Long adminId;//管理员id

    private String adminAccount;//管理员账号

    private String adminPassword;//管理员密码

    private String adminRealname;//管理员真实姓名

    @TableField("admin_ID_number")
    private String adminIdNumber;//管理员身份证号

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
