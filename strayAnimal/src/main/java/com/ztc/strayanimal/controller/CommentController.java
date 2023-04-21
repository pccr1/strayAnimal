package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.CommentInfo;
import com.ztc.strayanimal.service.CommentInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/comment/info")
@CrossOrigin("*")
public class CommentController {

    @Resource
    private CommentInfoService commentInfoService;

    /**
     * 根据帖子ID查评论
     * @param postId
     * @return
     */
    @PostMapping("/selectCommentInfo")
    public JsonResult selectCommentInfo(@RequestParam Long postId) {
        return commentInfoService.selectCommentInfo(postId);
    }

    /**
     * 添加评论
     *
     * @param commentInfo
     * @return
     */
    @PostMapping("/insertCommentInfo")
    public JsonResult insertCommentInfo(@ModelAttribute CommentInfo commentInfo) {
        return commentInfoService.insertCommentInfo(commentInfo);
    }

    /**
     * 点赞
     * @param commentId
     * @return
     */
    @PostMapping("/likeIs")
    public JsonResult likeIs(@RequestParam Long commentId) {
        return commentInfoService.likeIs(commentId);
    }

    /**
     * 取消点赞
     * @param commentId
     * @return
     */
    @PostMapping("/noLikeIs")
    public JsonResult noLikeIs(@RequestParam Long commentId) {
        return commentInfoService.noLikeIs(commentId);
    }

    /**
     * 评论删除
     * @param commentId
     * @return
     */
    @PostMapping("/deleteCommentInfo")
    public JsonResult deleteCommentInfo(@RequestParam Long commentId) {
        return commentInfoService.deleteCommentInfo(commentId);
    }
}
