package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.service.VoluntaryActivityInfoService;
import com.ztc.strayanimal.service.VolunteerInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/volunteer/info")
@CrossOrigin("*")
public class VolunteerController {

    @Resource
    private VolunteerInfoService volunteerInfoService;

    @Resource
    private VoluntaryActivityInfoService voluntaryActivityInfoService;

    /**
     *查看申请志愿者信息
     * @param volunteerId
     * @param pageSize
     * @param current
     * @return
     */
    @PostMapping("/getAllVolunteer")
    public JsonResult getAllVolunteer(@RequestParam(required = false) Long volunteerId,
                                      @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                                      @RequestParam(required = false,defaultValue = "1")Integer current){
        return volunteerInfoService.getAllVolunteer(volunteerId,pageSize,current);
    }

    /**
     * 保存暂返信息
     * @param volunteerId
     * @param volunteerReply
     * @return
     */
    @PostMapping("/updateVolunteerReply")
    public JsonResult updateVolunteerReply(@RequestParam Long volunteerId,
                                           @RequestParam String volunteerReply){
        return volunteerInfoService.updateVolunteerReply(volunteerId,volunteerReply);
    }

    /**
     * 同意成为志愿者
     * @param volunteerId
     * @return
     */
    @PostMapping("/updateVolunteerExamineState")
    public JsonResult updateVolunteerExamineState(@RequestParam Long volunteerId){
        return volunteerInfoService.updateVolunteerExamineState(volunteerId);
    }

    /**
     * 逻辑删除
     * @param volunteerId
     * @return
     */
    @PostMapping("/deleteVolunteerInfo")
    public JsonResult deleteVolunteerInfo(@RequestParam Long volunteerId){
        return volunteerInfoService.deleteVolunteerInfo(volunteerId);
    }

    /**
     * 模糊查询志愿者
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @PostMapping("/selectVol")
    public JsonResult selectVol(@ModelAttribute Vague vague,
                                @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                                @RequestParam(required = false,defaultValue = "1")Integer current){
        return volunteerInfoService.selectVol(vague,pageSize,current);
    }

    /**
     * 志愿者 查看详情
     * @param volunteerId
     * @return
     */
    @PostMapping("/selectVolunteer")
    public JsonResult selectVolunteer(@RequestParam Long volunteerId){
        return volunteerInfoService.selectVolunteer(volunteerId);
    }

    /**
     * 志愿者 查看详情 目前参加的志愿活动
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @PostMapping("/selectVoluntaryActivityInfo")
    public JsonResult selectVoluntaryActivityInfo(@ModelAttribute Vague vague,
                                                  @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                                                  @RequestParam(required = false,defaultValue = "1")Integer current){
        return voluntaryActivityInfoService.selectVoluntaryActivityInfo(vague,pageSize,current);
    }
}
