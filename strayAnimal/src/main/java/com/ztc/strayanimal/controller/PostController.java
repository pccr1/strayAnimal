package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.PostInfo;
import com.ztc.strayanimal.service.PostInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@ResponseBody
@RequestMapping("/post/info")
@CrossOrigin("*")
public class PostController {

    @Resource
    private PostInfoService postInfoService;

    /**
     * 查询帖子
     * @param postInfo
     * @return
     */
    @PostMapping("/selectPostInfo")
    public JsonResult selectPostInfo(@ModelAttribute PostInfo postInfo) {
        return postInfoService.selectPostInfo(postInfo);
    }

    /**
     * 添加帖子
     *
     * @param postInfo
     * @return
     */
    @PostMapping("/addPostInfo")
    public JsonResult addPostInfo(@ModelAttribute PostInfo postInfo) {
        return postInfoService.addPostInfo(postInfo);
    }

    /**
     * 点赞
     * @param postId
     * @return
     */
    @PostMapping("/likeIs")
    public JsonResult likeIs(@RequestParam Long postId) {
        return postInfoService.likeIs(postId);
    }

    /**
     * 取消点赞
     * @param postId
     * @return
     */
    @PostMapping("/noLikeIs")
    public JsonResult noLikeIs(@RequestParam Long postId) {
        return postInfoService.noLikeIs(postId);
    }


    /**
     * 删除帖子
     * @param postId
     * @return
     */
    @PostMapping("/deletePostInfo")
    public JsonResult deletePostInfo(@RequestParam Long postId) {
        return postInfoService.deletePostInfo(postId);
    }

}
