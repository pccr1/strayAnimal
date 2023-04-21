package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.SosInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.util.JsonResult;

public interface SosInfoService extends IService<SosInfo> {

    /**
     * 下拉菜单
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult selectSosInfo(Vague vague,Integer pageSize,Integer current);

    /**
     * 作为志愿活动发布
     * @param sosId
     * @return
     */
    public JsonResult addVoluntaryActivity(Integer sosId);

    /**
     * 设置为已处理
     * @param sosId
     * @return
     */
    public JsonResult updateSosStatus(Integer sosId);

    /**
     * 保存暂返信息
     * @param sosId
     * @param sosReply
     * @return
     */
    public JsonResult updateSosReply(Integer sosId,String sosReply);
}
