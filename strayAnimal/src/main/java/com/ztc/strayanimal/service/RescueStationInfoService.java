package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.RescueStationInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.util.JsonResult;

public interface RescueStationInfoService extends IService<RescueStationInfo> {

    /**
     * 模糊查询救助站
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult selectRescueStationInfo(Vague vague,Integer pageSize,Integer current);

    /**
     * 添加救助站信息
     * @param rescueStationInfo
     * @return
     */
    public JsonResult addRescueStationInfo(RescueStationInfo rescueStationInfo);

    /**
     * 逻辑删除
     * @param rescueStationId
     * @return
     */
    public JsonResult deleteRescueStationInfo(Long rescueStationId);

    /**
     * 修改救助站信息
     * @param rescueStationInfo
     * @return
     */
    public JsonResult updateRescueStationInfo(RescueStationInfo rescueStationInfo);
}
