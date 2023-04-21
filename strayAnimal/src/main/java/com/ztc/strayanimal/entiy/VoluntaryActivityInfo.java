package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import com.ztc.strayanimal.util.ExcelExport;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("voluntary_activity_info")
public class VoluntaryActivityInfo {

    @ExcelExport(value = "志愿活动ID")
    @TableId("voluntary_activity_id")
    private Long voluntaryActivityId;//志愿活动ID

    @TableField(exist = false)
    private Long ma;//最大志愿活动ID

    private Long volunteerId;//志愿者ID
    @ExcelExport(value = "活动名称")
    private String voluntaryActivityName;//活动名称
    @ExcelExport(value = "活动地址")
    private String voluntaryActivityAddress;//活动地址

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date voluntaryActivityTime;//活动时间
    @ExcelExport(value = "活动时间")
    @TableField(exist = false)
    private String strVoluntaryActivityTime;//活动时间str
    @ExcelExport(value = "活动人数")
    private Integer voluntaryActivityPeopleNumble;//活动人数

    private String status;//活动状态

    private String voluntaryActivityDetailedInformation;//活动详细信息

    @TableField(exist = false)
    private String userRealname;//用户真实姓名
    @TableField(exist = false)
    private String volunteerTitle;//志愿者称号

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
