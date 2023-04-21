package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.CommentInfo;
import com.ztc.strayanimal.util.JsonResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentInfoService extends IService<CommentInfo> {

    /**
     * 根据帖子ID查评论
     * @param postId
     * @return
     */
    public JsonResult selectCommentInfo(Long postId);

    /**
     * 添加评论
     * @param commentInfo
     * @return
     */
    public JsonResult insertCommentInfo(CommentInfo commentInfo);

    /**
     * 点赞
     * @param commentId
     * @return
     */
    public JsonResult likeIs(Long commentId);

    /**
     * 取消点赞
     * @param commentId
     * @return
     */
    public JsonResult noLikeIs(Long commentId);

    /**
     * 评论删除
     */
    public JsonResult deleteCommentInfo(Long commentId);
}
