package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.AnimalInfo;
import com.ztc.strayanimal.entiy.AnswerInfo;
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
     * 发送帖子
     * @param answerInfo
     * @return
     */
    @PostMapping("/addAnswerInfo")
    public JsonResult addAnswerInfo(@ModelAttribute AnswerInfo answerInfo) {
        return answerInfoService.addAnswerInfo(answerInfo);
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
