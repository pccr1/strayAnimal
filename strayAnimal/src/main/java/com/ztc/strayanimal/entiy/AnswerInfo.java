package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("answer_info")
public class AnswerInfo {
    /**
     * 回复ID
     */
    @TableId(type = IdType.AUTO)
    private Long answerId;

    /**
     * 回复的评论ID
     */
    @TableField(value = "comment_id")
    private Long commentId;

    /**
     * 回复者用户ID
     */
    @TableField(value = "answer_user_id")
    private Long answerUserId;

    /**
     * 被回复用户ID
     */
    @TableField(value = "to_be_answer_user_id")
    private Long toBeAnswerUserId;

    /**
     * 内容
     */
    @TableField(value = "answer_text", insertStrategy = FieldStrategy.NOT_NULL)
    private String answerText;

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

    @TableField(exist = false)
    private String strCreateTime;//str创建时间
}
