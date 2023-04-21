package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.service.SosInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/sos/info")
@CrossOrigin("*")
public class SosController {

    @Resource
    private SosInfoService sosInfoService;

    /**
     * 下拉菜单
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @PostMapping("/selectSosInfo")
    public JsonResult selectSosInfo(@ModelAttribute Vague vague,
                                    @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                                    @RequestParam(required = false,defaultValue = "1")Integer current){
        return sosInfoService.selectSosInfo(vague,pageSize,current);
    }

    /**
     * 作为志愿活动发布
     * @param sosId
     * @return
     */
    @PostMapping("/addVoluntaryActivity")
    public JsonResult addVoluntaryActivity(@RequestParam Integer sosId){
        return sosInfoService.addVoluntaryActivity(sosId);
    }

    /**
     * 设置为已处理
     * @param sosId
     * @return
     */
    @PostMapping("/updateSosStatus")
    public JsonResult updateSosStatus(@RequestParam Integer sosId){
        return sosInfoService.updateSosStatus(sosId);
    }

    /**
     * 保存暂返信息
     * @param sosId
     * @param sosReply
     * @return
     */
    @PostMapping("/updateSosReply")
    public JsonResult updateSosReply(@RequestParam Integer sosId,
                                     @RequestParam String sosReply){
        return sosInfoService.updateSosReply(sosId,sosReply);
    }
}
