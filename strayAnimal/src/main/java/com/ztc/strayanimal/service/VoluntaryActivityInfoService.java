package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VoluntaryActivityInfo;
import com.ztc.strayanimal.entiy.VolunteerInfo;
import com.ztc.strayanimal.util.JsonResult;

public interface VoluntaryActivityInfoService extends IService<VoluntaryActivityInfo> {

    /**
     * 模糊查询志愿活动
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult selectVoluntaryActivityInfo(Vague vague,Integer pageSize,Integer current);

    /**
     * 查看详情 活动详细信息
     * @param voluntaryActivityId
     * @return
     */
    public JsonResult selectVoluntaryActivityDetailedInformation(Long voluntaryActivityId);

    /**
     * 查看参加活动的志愿者
     * @param voluntaryActivityId
     * @return
     */
    public JsonResult selectVolunteer(Long voluntaryActivityId);

    /**
     * 添加志愿活动
     * @param voluntaryActivityInfo
     * @return
     */
    public JsonResult addVoluntaryActivity(VoluntaryActivityInfo voluntaryActivityInfo);

    /**
     * 为志愿活动添加志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @param userRealname
     * @return
     */
    public JsonResult addVolunteer(Long voluntaryActivityId,Long volunteerId,String userRealname);

    /**
     * 删除志愿活动
     * @param voluntaryActivityId
     * @return
     */
    public JsonResult deleteVoluntaryActivity(Long voluntaryActivityId);

    /**
     * 删除参加志愿活动的志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @return
     */
    public JsonResult deleteVolunteer(Long voluntaryActivityId,Long volunteerId);

    /**
     * 修改志愿活动信息
     * @param voluntaryActivityInfo
     * @return
     */
    public JsonResult updateVoluntaryActivity(VoluntaryActivityInfo voluntaryActivityInfo);
}
