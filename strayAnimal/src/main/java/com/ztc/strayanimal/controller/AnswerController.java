package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.service.AnswerInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/answer/info")
@CrossOrigin("*")
public class AnswerController {

    @Resource
    private AnswerInfoService answerInfoService;

    /**
     * 回复预览
     * @param commentId
     * @return
     */
    @PostMapping("/selectAnswerInfo")
    public JsonResult selectAnswerInfo(@RequestParam Long commentId) {
        return answerInfoService.selectAnswerInfo(commentId);
    }

    /**
     * 删除帖子
     * @param answerId
     * @return
     */
    @PostMapping("/deleteAnswerInfo")
    public JsonResult deleteAnswerInfo(@RequestParam Long answerId) {
        return answerInfoService.deleteAnswerInfo(answerId);
    }
}
