package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.PostInfo;
import com.ztc.strayanimal.util.JsonResult;

public interface PostInfoService extends IService<PostInfo> {

    /**
     * 帖子预览
     * @param postInfo
     * @return
     */
    public JsonResult selectPostInfo(PostInfo postInfo);

    /**
     * 发布帖子
     * @param postInfo
     * @return
     */
    public JsonResult addPostInfo(PostInfo postInfo);

    /**
     * 点赞
     * @param postId
     * @return
     */
    public JsonResult likeIs(Long postId);

    /**
     * 取消点赞
     * @param postId
     * @return
     */
    public JsonResult noLikeIs(Long postId);

    /**
     * 帖子删除
     */
    public JsonResult deletePostInfo(Long postId);
}
