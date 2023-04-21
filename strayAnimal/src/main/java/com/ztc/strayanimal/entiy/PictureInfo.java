package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "picture_info")
public class PictureInfo {

    /**
     * 图片ID
     */
    @TableId(value = "picture_id", type = IdType.AUTO)
    private Long pictureId;

    /**
     * 帖子ID
     */
    @TableField(value = "post_id")
    private Long postId;

    /**
     * 评论ID
     */
    @TableField(value = "comment_id")
    private Long commentId;

    /**
     * 小动物ID
     */
    @TableField(value = "animal_id")
    private Long animalId;

    /**
     * 图片地址
     */
    @TableField(value = "picture_url")
    private String pictureUrl;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除（默认0）
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete;

}
