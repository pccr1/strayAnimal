package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.PostInfo;
import com.ztc.strayanimal.mapper.PostInfoMapper;
import com.ztc.strayanimal.service.PostInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PostInfoServiceImpl extends ServiceImpl<PostInfoMapper, PostInfo> implements PostInfoService {

    @Resource
    private PostInfoMapper postInfoMapper;

    /**
     * 帖子预览
     * @param postHeadline
     * @return
     */
    @Override
    public JsonResult selectPostInfo(String postHeadline) {
        List<PostInfo> result = postInfoMapper.selectPostInfo(postHeadline);
        JsonResult jsonResult = new JsonResult();
        for (int i = 0; i < result.size(); i++) {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.get(i).getCreateTime());
            result.get(i).setStrCreateTime(format);
        }
        if (result.size() > 0) {
            jsonResult = jsonResult.requestSuccess(result);
        } else {
            jsonResult = jsonResult.resultFail("没有数据");
        }
        return jsonResult;
    }

    /**
     * 添加帖子
     *
     * @param postInfo
     * @return
     */
    @Override
    public JsonResult addPostInfo(PostInfo postInfo) {
        PostInfo postInfo1 = new PostInfo();
        postInfo1.setPostHeadline(postInfo.getPostHeadline());
        postInfo1.setPostText(postInfo.getPostText());
        int result = postInfoMapper.insertPostInfo(postInfo1);
        JsonResult jsonResult = new JsonResult();
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(postInfo1.getPostId());
        } else {
            jsonResult = jsonResult.resultFail("帖子发布失败！");
        }
        return jsonResult;
    }

    /**
     * 点赞
     * @param postId
     * @return
     */
    @Override
    public JsonResult likeIs(Long postId) {
        JsonResult jsonResult = new JsonResult();
        int result = postInfoMapper.likeIs(postId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("点赞失败！");
        }
        return jsonResult;
    }

    /**
     * 取消点赞
     * @param postId
     * @return
     */
    @Override
    public JsonResult noLikeIs(Long postId) {
        JsonResult jsonResult = new JsonResult();
        int result = postInfoMapper.noLikeIs(postId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("取消失败！");
        }
        return jsonResult;
    }

    /**
     * 帖子删除
     */
    @Override
    public JsonResult deletePostInfo(Long postId) {
        JsonResult jsonResult = new JsonResult();
        int result = postInfoMapper.deletePostInfo(postId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("删除失败！");
        }
        return jsonResult;
    }
}
