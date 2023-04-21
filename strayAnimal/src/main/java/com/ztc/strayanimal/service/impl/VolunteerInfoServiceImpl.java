package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VoluntaryActivityInfo;
import com.ztc.strayanimal.entiy.VolunteerInfo;
import com.ztc.strayanimal.mapper.VoluntaryActivityInfoMapper;
import com.ztc.strayanimal.mapper.VolunteerInfoMapper;
import com.ztc.strayanimal.service.VolunteerInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class VolunteerInfoServiceImpl extends ServiceImpl<VolunteerInfoMapper, VolunteerInfo> implements VolunteerInfoService {

    @Resource
    private VolunteerInfoMapper volunteerInfoMapper;

    /**
     * 查看申请志愿者信息
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult getAllVolunteer(Long volunteerId,Integer pageSize, Integer current) {
        JsonResult jsonResult = new JsonResult();
        Page<VolunteerInfo> page = new Page<>(current,pageSize);
        Page<VolunteerInfo> page1 = volunteerInfoMapper.selectVolunteerInfo(page,volunteerId);
        if (page1.getRecords() != null) {
            jsonResult = jsonResult.requestSuccess((List) page1.getRecords());
            jsonResult.setCountSize((int) page1.getTotal());

        } else {
            jsonResult.resultFail("请求失败");
        }

        return jsonResult;
    }

    /**
     * 保存暂返信息
     * @param volunteerId
     * @param volunteerReply
     * @return
     */
    @Override
    public JsonResult updateVolunteerReply(Long volunteerId, String volunteerReply) {
        JsonResult jsonResult = new JsonResult();
        int result = volunteerInfoMapper.updateVolunteerReply(volunteerId,volunteerReply);
        if(result > 0){
            volunteerInfoMapper.deleteVolunteerInfo(volunteerId);
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("暂返失败");
        }
        return jsonResult;
    }

    /**
     * 同意成为志愿者
     * @param volunteerId
     * @return
     */
    @Override
    public JsonResult updateVolunteerExamineState(Long volunteerId) {
        JsonResult jsonResult = new JsonResult();
        int result = volunteerInfoMapper.updateVolunteerExamineState(volunteerId);
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("操作失败");
        }
        return jsonResult;
    }

    /**
     * 逻辑删除
     * @param volunteerId
     * @return
     */
    @Override
    public JsonResult deleteVolunteerInfo(Long volunteerId) {
        JsonResult jsonResult = new JsonResult();
        int result = volunteerInfoMapper.deleteVolunteerInfo(volunteerId);
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("删除失败");
        }
        return jsonResult;
    }

    /**
     * 模糊查询志愿者
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult selectVol(Vague vague, Integer pageSize, Integer current) {
        if (vague == null){
            vague = new Vague();
        }
        JsonResult jsonResult = new JsonResult();
        Page<VolunteerInfo> page = new Page<>(current,pageSize);
        Page<VolunteerInfo> volunteerInfoPage = volunteerInfoMapper.selectVol(page,vague);
        if (volunteerInfoPage.getRecords() != null){
            jsonResult = jsonResult.requestSuccess((List)volunteerInfoPage.getRecords());
            jsonResult.setCountSize((int)volunteerInfoPage.getTotal());
        }else {
            jsonResult = jsonResult.resultFail("请求失败");
        }
        return jsonResult;
    }

    /**
     * 志愿者 查看详情
     * @param volunteerId
     * @return
     */
    @Override
    public JsonResult selectVolunteer(Long volunteerId) {
        JsonResult jsonResult = new JsonResult();
        VolunteerInfo volunteerInfo = volunteerInfoMapper.selectVolunteer(volunteerId);
        if (volunteerInfo != null) {
            if(volunteerInfo.getUserBirthday() != null){
                String strUserBirthday = new SimpleDateFormat("yyyy-MM-dd").format(volunteerInfo.getUserBirthday());
                volunteerInfo.setStrUserBirthday(strUserBirthday);
            }
            if(volunteerInfo.getCreateTime() != null){
                String strCreateTime = new SimpleDateFormat("yyyy-MM-dd").format(volunteerInfo.getCreateTime());
                volunteerInfo.setStrCreateTime(strCreateTime);
            }
            if (volunteerInfo.getUpdateTime() != null){
                String strUpdateTime = new SimpleDateFormat("yyyy-MM-dd").format(volunteerInfo.getUpdateTime());
                volunteerInfo.setStrUpdateTime(strUpdateTime);
            }
            jsonResult = jsonResult.requestSuccess(volunteerInfo);
        }else {
            jsonResult = jsonResult.resultFail("查看失败");
        }
        return jsonResult;
    }
}
