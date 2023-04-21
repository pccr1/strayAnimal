package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sos_info")
public class SosInfo {

    @TableId("sos_id")
    private Integer sosId;//紧急救助ID

    private Long userId;//发布救助用户ID

    private String sosName;//救助名称

    private String sosAddress;//救助地址

    private String sosStatus;//处理状态(未处理 处理中 已完成)

    private String sosDetailedInformation;//救助详细信息

    private String sosReply;//紧急救助暂返信息

    @TableField(exist = false)
    private String strCreateTime;//创建时间str

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
