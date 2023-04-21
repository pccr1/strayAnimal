package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.RescueStationInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.mapper.RescueStationInfoMapper;
import com.ztc.strayanimal.service.RescueStationInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RescueStationInfoServiceImpl extends ServiceImpl<RescueStationInfoMapper, RescueStationInfo> implements RescueStationInfoService {

    @Resource
    private RescueStationInfoMapper rescueStationInfoMapper;

    /**
     * 模糊查询救助站信息
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult selectRescueStationInfo(Vague vague, Integer pageSize, Integer current) {
        if (vague == null){
            vague = new Vague();
        }
        JsonResult jsonResult = new JsonResult();
        Page<RescueStationInfo> page = new Page<>(current,pageSize);
        Page<RescueStationInfo> rescueStationInfoPage = rescueStationInfoMapper.selectRescueStationInfo(page,vague);
        if (rescueStationInfoPage.getRecords() != null){
            jsonResult = jsonResult.requestSuccess((List)rescueStationInfoPage.getRecords());
            jsonResult.setCountSize((int)rescueStationInfoPage.getTotal());
        }else {
            jsonResult = jsonResult.resultFail("查询失败");
        }
        return jsonResult;
    }

    /**
     * 添加救助站信息
     * @param rescueStationInfo
     * @return
     */
    @Override
    public JsonResult addRescueStationInfo(RescueStationInfo rescueStationInfo) {
        JsonResult jsonResult = new JsonResult();
        int result = rescueStationInfoMapper.insert(rescueStationInfo);
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("添加失败");
        }
        return jsonResult;
    }

    /**
     * 逻辑删除
     * @param rescueStationId
     * @return
     */
    @Override
    public JsonResult deleteRescueStationInfo(Long rescueStationId) {
        JsonResult jsonResult = new JsonResult();
        int result = rescueStationInfoMapper.deleteRescueStationInfo(rescueStationId);
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("删除失败");
        }
        return jsonResult;
    }

    /**
     * 修改救助站信息
     * @param rescueStationInfo
     * @return
     */
    @Override
    public JsonResult updateRescueStationInfo(RescueStationInfo rescueStationInfo) {
        JsonResult jsonResult = new JsonResult();
        int result = rescueStationInfoMapper.updateById(rescueStationInfo);
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("修改失败");
        }
        return jsonResult;
    }
}
