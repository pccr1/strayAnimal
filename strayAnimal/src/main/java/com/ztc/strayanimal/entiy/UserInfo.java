package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_info")
public class UserInfo {

    @TableId("user_id")
    private Long userId;//用户ID

    private String userNetWorkName;//用户网名

    private String userAccount;//用户账号

    private String userPassword;//用户密码

    private String userRealname;//用户真实姓名

    @TableField("user_ID_number")
    private String userIdNumber;//用户身份证号

    private String userAvatar;//用户头像

    private String userEmail;//用户邮箱

    private String userPhone;//用户电话

    private String userSex;//用户性别

    private String userNation;//用户民族

    @TableField(exist = false)
    private String strUserBirthday;//用户出生日期str
    private Date userBirthday;//用户出生日期

    private String userAge;//用户年龄

    private String userAddress;//用户地址

    private String userTitle;//用户称号

    private String userReply;//领养申请暂返信息

    private String userLevel;//用户等级

    private Integer userConcern;//用户的关注数

    private Integer userFans;//用户的粉丝数

    private Long userLike;//用户的获赞数

    @TableField(exist = false)
    private String strCreateTime;//创建时间str
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(exist = false)
    private String strUpdateTime;//修改时间str
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
