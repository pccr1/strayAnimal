package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.strayanimal.entiy.CommentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentInfoMapper extends BaseMapper<CommentInfo> {

    /**
     * 根据帖子ID查评论
     * @param postId
     * @return
     */
    List<CommentInfo> selectCommentInfo(@Param("postId")Long postId);

    /**
     * 添加评论
     * @param commentInfo
     * @return
     */
    int insertCommentInfo(CommentInfo commentInfo);

    /**
     * 点赞
     * @param commentId
     * @return
     */
    int likeIs(Long commentId);

    /**
     * 取消点赞
     * @param commentId
     * @return
     */
    int noLikeIs(Long commentId);

    /**
     * 评论删除
     */
    int deleteCommentInfo(Long commentId);
}
