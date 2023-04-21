package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VolunteerInfo;
import com.ztc.strayanimal.util.JsonResult;

public interface VolunteerInfoService extends IService<VolunteerInfo> {

    /**
     * 查看申请志愿者信息
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult getAllVolunteer(Long volunteerId,Integer pageSize,Integer current);

    /**
     * 保存暂返信息
     * @param volunteerId
     * @param volunteerReply
     * @return
     */
    public JsonResult updateVolunteerReply(Long volunteerId,String volunteerReply);

    /**
     * 同意成为志愿者
     * @param volunteerId
     * @return
     */
    public JsonResult updateVolunteerExamineState(Long volunteerId);

    /**
     * 逻辑删除
     * @param volunteerId
     * @return
     */
    public JsonResult deleteVolunteerInfo(Long volunteerId);

    /**
     * 模糊查询志愿者
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult selectVol(Vague vague,Integer pageSize,Integer current);

    /**
     * 志愿者 查看详情
     * @param volunteerId
     * @return
     */
    public JsonResult selectVolunteer(Long volunteerId);
}
