package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.CommentInfo;
import com.ztc.strayanimal.mapper.CommentInfoMapper;
import com.ztc.strayanimal.service.CommentInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements CommentInfoService {

    @Resource
    private CommentInfoMapper commentInfoMapper;

    /**
     * 根据帖子ID查评论
     * @param postId
     * @return
     */
    @Override
    public JsonResult selectCommentInfo(Long postId) {
        JsonResult jsonResult = new JsonResult();
        List<CommentInfo> result = commentInfoMapper.selectCommentInfo(postId);
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
     * 添加评论
     * @param commentInfo
     * @return
     */
    @Override
    public JsonResult insertCommentInfo(CommentInfo commentInfo) {
        JsonResult jsonResult = new JsonResult();
//        Date t = new Date();
//        commentInfo.setCreateTime(t);
//        commentInfo.setUpdateTime(t);
        int result = commentInfoMapper.insert(commentInfo);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(commentInfo.getCommentId());
        } else {
            jsonResult = jsonResult.resultFail("评论发布失败！");
        }
        return jsonResult;
    }

    /**
     * 点赞
     * @param commentId
     * @return
     */
    @Override
    public JsonResult likeIs(Long commentId) {
        JsonResult jsonResult = new JsonResult();
        int result = commentInfoMapper.likeIs(commentId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("点赞失败！");
        }
        return jsonResult;
    }

    /**
     * 取消点赞
     * @param commentId
     * @return
     */
    @Override
    public JsonResult noLikeIs(Long commentId) {
        JsonResult jsonResult = new JsonResult();
        int result = commentInfoMapper.noLikeIs(commentId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("取消失败！");
        }
        return jsonResult;
    }

    /**
     * 评论删除
     */
    @Override
    public JsonResult deleteCommentInfo(Long commentId) {
        JsonResult jsonResult = new JsonResult();
        int result = commentInfoMapper.deleteCommentInfo(commentId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("删除失败！");
        }
        return jsonResult;
    }
}

