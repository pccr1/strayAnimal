package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("post_info")
public class PostInfo {

    /**
     * 帖子ID
     */
    @TableId(type = IdType.AUTO)
    private Long postId;

    /**
     * 发帖人ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 帖子标题
     */
    @TableField(value = "post_headline")
    private String postHeadline;

    /**
     * 正文
     */
    @TableField(value = "post_text")
    private String postText;

    /**
     * 点赞数
     */
    @TableField(value = "post_like")
    private Integer postLike;

    /**
     * 评论数
     */
    @TableField(value = "post_comment")
    private Integer postComment;

    /**
     * 创建时间，添加时自动写入
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private String strCreateTime;//str创建时间

    /**
     * 修改时间，添加或更新时自动写入
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除（默认0）
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private String userAvatar;//用户头像

    @TableField(exist = false)
    private String userNetWorkName;//用户网名

    @TableField(exist = false)
    private String userTitle;//用户称号

    @TableField(exist = false)
    private String userLevel;//用户等级

    /**
     * 图片地址
     */
    @TableField(exist = false)
    private String pictureUrl;
}
