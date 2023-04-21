package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VoluntaryActivityInfo;
import com.ztc.strayanimal.mapper.VoluntaryActivityInfoMapper;
import com.ztc.strayanimal.service.VoluntaryActivityInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class VoluntaryActivityInfoServiceImpl extends ServiceImpl<VoluntaryActivityInfoMapper, VoluntaryActivityInfo> implements VoluntaryActivityInfoService {

    @Resource
    private VoluntaryActivityInfoMapper voluntaryActivityInfoMapper;

    /**
     * 志愿活动模糊查询
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult selectVoluntaryActivityInfo(Vague vague, Integer pageSize, Integer current){
        if (vague == null) {
            vague = new Vague();
        }
        JsonResult jsonResult = new JsonResult();
        Page<VoluntaryActivityInfo> page = new Page<>(current, pageSize);
        Page<VoluntaryActivityInfo> voluntaryActivityInfoPage = voluntaryActivityInfoMapper.selectVoluntaryActivityInfo(page,vague);
        if (voluntaryActivityInfoPage.getRecords() != null) {
            for (int i = 0;i < voluntaryActivityInfoPage.getRecords().size();i++){
                if (voluntaryActivityInfoPage.getRecords().get(i).getVoluntaryActivityTime() != null) {
                    String string = new SimpleDateFormat("yyyy-MM-dd").format(voluntaryActivityInfoPage.getRecords().get(i).getVoluntaryActivityTime());
                    voluntaryActivityInfoPage.getRecords().get(i).setStrVoluntaryActivityTime(string);
                }
            }
            jsonResult = jsonResult.requestSuccess((List) voluntaryActivityInfoPage.getRecords());
            jsonResult.setCountSize((int) voluntaryActivityInfoPage.getTotal());
        } else {
            jsonResult.resultFail("请求失败");
        }

        return jsonResult;
    }

    /**
     * 志愿活动 查看详情信息
     * @param voluntaryActivityId
     * @return
     */
    @Override
    public JsonResult selectVoluntaryActivityDetailedInformation(Long voluntaryActivityId) {
        List<VoluntaryActivityInfo> string = voluntaryActivityInfoMapper.selectVoluntaryActivityDetailedInformation(voluntaryActivityId);
        JsonResult jsonResult = new JsonResult();
        if (string.size() > 0){
            jsonResult = jsonResult.requestSuccess(string);
        }else {
            jsonResult = jsonResult.resultFail("没有数据");
        }
        return jsonResult;
    }

    /**
     * 查询参加活动的志愿者
     * @param voluntaryActivityId
     * @return
     */
    @Override
    public JsonResult selectVolunteer(Long voluntaryActivityId) {
        List<VoluntaryActivityInfo> list = voluntaryActivityInfoMapper.selectVolunteer(voluntaryActivityId);
        JsonResult jsonResult = new JsonResult();
        if (list.size() > 0){
            jsonResult = jsonResult.requestSuccess(list);
        }else {
            jsonResult = jsonResult.resultFail("没有数据");
        }
        return jsonResult;
    }

    /**
     * 添加志愿活动
     * @param voluntaryActivityInfo
     * @return
     */
    @Override
    public JsonResult addVoluntaryActivity(VoluntaryActivityInfo voluntaryActivityInfo) {
        List<VoluntaryActivityInfo> id = voluntaryActivityInfoMapper.selectMax();
        voluntaryActivityInfo.setVoluntaryActivityId(id.get(0).getMa()+1);
        int result = voluntaryActivityInfoMapper.insert(voluntaryActivityInfo);
        JsonResult jsonResult = new JsonResult();
        if(result>0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("添加失败");
        }
        return jsonResult;
    }

    /**
     * 为志愿活动添加志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @param userRealname
     * @return
     */
    @Override
    public JsonResult addVolunteer(Long voluntaryActivityId, Long volunteerId, String userRealname) {
        VoluntaryActivityInfo voluntaryActivityInfo = voluntaryActivityInfoMapper.selectTary(voluntaryActivityId);
        List<VoluntaryActivityInfo> name = voluntaryActivityInfoMapper.selectTeer(volunteerId);
        List<VoluntaryActivityInfo> list = voluntaryActivityInfoMapper.selectVolunteer(voluntaryActivityId);
        JsonResult jsonResult = new JsonResult();
        if(name.size() == 0){
            return new JsonResult().resultFail("志愿者ID不存在");
        }
        if(!name.get(0).getUserRealname().equals(userRealname)){
            return new JsonResult().resultFail("志愿者姓名或ID错误");
        }
        for (int i = 0;i < list.size();i++){
            if (list.get(i).getVolunteerId() == volunteerId){
                jsonResult = jsonResult.resultFail("该志愿者已经添加");
                return jsonResult;
            }
        }
        if(list.size() >= voluntaryActivityInfo.getVoluntaryActivityPeopleNumble()){
            jsonResult = jsonResult.resultFail("志愿者数量已达最大值");
        }else {
            voluntaryActivityInfo.setVolunteerId(volunteerId);
            int result = voluntaryActivityInfoMapper.insert(voluntaryActivityInfo);
            if (result > 0){
                jsonResult = jsonResult.requestSuccess(null);
            }else {
                jsonResult = jsonResult.resultFail("添加失败");
            }
        }
        return jsonResult;
    }

    /**
     * 删除志愿活动
     * @param voluntaryActivityId
     * @return
     */
    @Override
    public JsonResult deleteVoluntaryActivity(Long voluntaryActivityId) {
        int result = voluntaryActivityInfoMapper.deleteVoluntaryActivity(voluntaryActivityId);
        JsonResult jsonResult = new JsonResult();
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("删除失败");
        }
        return jsonResult;
    }

    /**
     * 删除参加志愿活动的志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @return
     */
    @Override
    public JsonResult deleteVolunteer(Long voluntaryActivityId, Long volunteerId) {
        int result = voluntaryActivityInfoMapper.deleteVolunteer(voluntaryActivityId,volunteerId);
        JsonResult jsonResult = new JsonResult();
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("删除失败");
        }
        return jsonResult;
    }

    /**
     * 修改志愿活动信息
     * @param voluntaryActivityInfo
     * @return
     */
    @Override
    public JsonResult updateVoluntaryActivity(VoluntaryActivityInfo voluntaryActivityInfo) {
        int result = voluntaryActivityInfoMapper.updateById(voluntaryActivityInfo);
        JsonResult jsonResult = new JsonResult();
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("修改失败");
        }
        return jsonResult;
    }
}
