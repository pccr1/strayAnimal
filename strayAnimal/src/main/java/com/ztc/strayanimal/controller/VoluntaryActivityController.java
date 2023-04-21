package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.ExportAnimal;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VoluntaryActivityInfo;
import com.ztc.strayanimal.mapper.VoluntaryActivityInfoMapper;
import com.ztc.strayanimal.service.VoluntaryActivityInfoService;
import com.ztc.strayanimal.util.ExcelUtils;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/voluntaryActivity/info")
@CrossOrigin("*")
public class VoluntaryActivityController {


    @Resource
    private VoluntaryActivityInfoService voluntaryActivityInfoService;



    @GetMapping("/exportVoluntarActivity")
    public void  exportVoluntarActivity(HttpServletResponse response){
        JsonResult jsonResult = voluntaryActivityInfoService.selectVoluntaryActivityInfo(null, 9999, 1);
        List<VoluntaryActivityInfo> object = (List<VoluntaryActivityInfo>) jsonResult.getObject();
        ExcelUtils.export(response,"志愿活动信息",object, VoluntaryActivityInfo.class);
    }
    /**
     * 志愿活动模糊查询
     * @param
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

    /**
     * 志愿活动 查看详情
     * @param voluntaryActivityId
     * @return
     */
    @PostMapping("/selectVoluntaryActivityDetailedInformation")
    public JsonResult selectVoluntaryActivityDetailedInformation(@RequestParam Long voluntaryActivityId){
        return voluntaryActivityInfoService.selectVoluntaryActivityDetailedInformation(voluntaryActivityId);
    }

    /**
     * 查询参加活动的志愿者
     * @param voluntaryActivityId
     * @return
     */
    @PostMapping("/selectVolunteer")
    public JsonResult selectVolunteer(@RequestParam Long voluntaryActivityId){
        return voluntaryActivityInfoService.selectVolunteer(voluntaryActivityId);
    }

    /**
     * 添加志愿活动
     * @param voluntaryActivityInfo
     * @return
     */
    @PostMapping("/addVoluntaryActivity")
    public JsonResult addVoluntaryActivity(@ModelAttribute VoluntaryActivityInfo voluntaryActivityInfo){
        return voluntaryActivityInfoService.addVoluntaryActivity(voluntaryActivityInfo);
    }

    /**
     * 为志愿活动添加志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @param userRealname
     * @return
     */
    @PostMapping("/addVolunteer")
    public JsonResult addVolunteer(@RequestParam Long voluntaryActivityId,
                                   @RequestParam Long volunteerId,
                                   @RequestParam String userRealname){
        return voluntaryActivityInfoService.addVolunteer(voluntaryActivityId,volunteerId,userRealname);
    }

    /**
     * 删除志愿活动
     * @param voluntaryActivityId
     * @return
     */
    @PostMapping("/deleteVoluntaryActivity")
    public JsonResult deleteVoluntaryActivity(@RequestParam Long voluntaryActivityId){
        return  voluntaryActivityInfoService.deleteVoluntaryActivity(voluntaryActivityId);
    }

    /**
     * 删除参加志愿活动的志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @return
     */
    @PostMapping("/deleteVolunteer")
    public JsonResult deleteVolunteer(@RequestParam Long voluntaryActivityId,
                                      @RequestParam Long volunteerId){
        return voluntaryActivityInfoService.deleteVolunteer(voluntaryActivityId,volunteerId);
    }

    /**
     * 修改志愿活动信息
     * @param voluntaryActivityInfo
     * @return
     */
    @PostMapping("/updateVoluntaryActivity")
    public JsonResult updateVoluntaryActivity(@ModelAttribute VoluntaryActivityInfo voluntaryActivityInfo){
        return voluntaryActivityInfoService.updateVoluntaryActivity(voluntaryActivityInfo);
    }
}
