package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.RescueStationInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.service.RescueStationInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/rescueStation/info")
@CrossOrigin("*")
public class RescueStationController {

    @Resource
    private RescueStationInfoService rescueStationInfoService;

    /**
     * 模糊查询救助站信息
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @PostMapping("/selectRescueStationInfo")
    public JsonResult selectRescueStationInfo(@ModelAttribute Vague vague,
                                              @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                              @RequestParam(required = false,defaultValue = "1") Integer current){
        return rescueStationInfoService.selectRescueStationInfo(vague,pageSize,current);
    }

    /**
     * 添加救助站信息
     * @param rescueStationInfo
     * @return
     */
    @PostMapping("/addRescueStationInfo")
    public JsonResult addRescueStationInfo(@ModelAttribute RescueStationInfo rescueStationInfo){
        return rescueStationInfoService.addRescueStationInfo(rescueStationInfo);
    }

    /**
     * 逻辑删除
     * @param rescueStationId
     * @return
     */
    @PostMapping("/deleteRescueStationInfo")
    public JsonResult deleteRescueStationInfo(@RequestParam Long rescueStationId){
        return rescueStationInfoService.deleteRescueStationInfo(rescueStationId);
    }

    /**
     * 修改救助站信息
     * @param rescueStationInfo
     * @return
     */
    @PostMapping("/updateRescueStationInfo")
    public JsonResult updateRescueStationInfo(@ModelAttribute RescueStationInfo rescueStationInfo){
        return rescueStationInfoService.updateRescueStationInfo(rescueStationInfo);
    }
}
