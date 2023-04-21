package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("comment_info")
public class CommentInfo {
    @TableId(type = IdType.AUTO)
    private Long commentId; // 评论ID

    @TableField
    private Long postId; // 帖子ID

    @TableField
    private Long userId; // 发帖用戶ID

    @TableField
    private String commentText; // 正文

    @TableField
    private Integer commentLike; // 评论点赞数

    @TableField(exist = false)
    private String strCreateTime;//创建时间str

    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // 修改时间

    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete; // 逻辑删除（默认0）

    @TableField(exist = false)
    private String userAvatar;//用户头像

    @TableField(exist = false)
    private String userNetWorkName;//用户网名

    @TableField(exist = false)
    private String userTitle;//用户称号

    @TableField(exist = false)
    private String userLevel;//用户等级
}

