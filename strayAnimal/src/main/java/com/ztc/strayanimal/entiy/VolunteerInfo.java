package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("volunteer_info")
public class VolunteerInfo {

    @TableId("volunteer_id")
    private Long volunteerId;//志愿者ID

    private Long volunteerUserId;//申请成为志愿者的用户ID

    private Integer volunteerExamineState;//审核状态

    private Integer volunteerActivitiesNumber;//志愿活动次数

    private String volunteerOldActivities;//过去参加志愿活动情况

    @TableField(exist = false)
    private Date userBirthday;//用户出生日期
    @TableField(exist = false)
    private String strUserBirthday;//str用户出生日期
    @TableField(exist = false)
    private String userNetWorkName;//用户网名
    @TableField(exist = false)
    private String userRealname;//用户真实姓名
    @TableField(exist = false)
    private String userIdNumber;//用户身份证号
    @TableField(exist = false)
    private String userPhone;//用户联系方式
    @TableField(exist = false)
    private String userSex;//用户性别
    @TableField(exist = false)
    private String userAge;//用户年龄
    @TableField(exist = false)
    private String userAddress;//用户地址

    private String volunteerTitle;//志愿者称号

    private String adoptionNotes;//申请备注

    private String volunteerReply;//暂返信息

    @TableField(exist = false)
    private String strCreateTime;//str创建时间
    @TableField(exist = false)
    private String strUpdateTime;//str修改时间

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
