package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.strayanimal.entiy.PostInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostInfoMapper extends BaseMapper<PostInfo> {

    /**
     * 帖子预览
     * @param postInfo
     * @return
     */
    List<PostInfo> selectPostInfo(@Param("po")PostInfo postInfo);

    /**
     * 添加帖子
     * @param postInfo
     * @return
     */
    int insertPostInfo(PostInfo postInfo);

    /**
     * 点赞
     * @param postId
     * @return
     */
    int likeIs(Long postId);

    /**
     * 取消点赞
     * @param postId
     * @return
     */
    int noLikeIs(Long postId);

    /**
     * 帖子删除
     */
    int deletePostInfo(Long postId);
}
