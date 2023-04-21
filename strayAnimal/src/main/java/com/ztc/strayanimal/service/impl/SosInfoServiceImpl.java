package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.SosInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VoluntaryActivityInfo;
import com.ztc.strayanimal.mapper.SosInfoMapper;
import com.ztc.strayanimal.mapper.VoluntaryActivityInfoMapper;
import com.ztc.strayanimal.service.SosInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SosInfoServiceImpl extends ServiceImpl<SosInfoMapper, SosInfo> implements SosInfoService {

    @Resource
    private SosInfoMapper sosInfoMapper;

    @Resource
    private VoluntaryActivityInfoMapper voluntaryActivityInfoMapper;

    /**
     * 下拉菜单
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult selectSosInfo(Vague vague, Integer pageSize, Integer current) {
        if (vague == null) {
            vague = new Vague();
        }
        JsonResult jsonResult = new JsonResult();
        Page<SosInfo> page = new Page<>(current,pageSize);
        Page<SosInfo> sosInfoPage = sosInfoMapper.selectSosInfo(page,vague);
        if (sosInfoPage.getRecords() != null){
            for (int i = 0;i < sosInfoPage.getRecords().size();i++){
                String str = new SimpleDateFormat("yyyy-MM-dd").format(sosInfoPage.getRecords().get(i).getCreateTime());
                sosInfoPage.getRecords().get(i).setStrCreateTime(str);
            }
            jsonResult = jsonResult.requestSuccess((List) sosInfoPage.getRecords());
            jsonResult.setCountSize((int) sosInfoPage.getTotal());
        } else {
            jsonResult.resultFail("请求失败");
        }

        return jsonResult;
    }

    /**
     * 作为志愿活动发布
     * @param sosId
     * @return
     */
    @Override
    public JsonResult addVoluntaryActivity(Integer sosId) {
        JsonResult jsonResult = new JsonResult();
        VoluntaryActivityInfo voluntaryActivityInfo = new VoluntaryActivityInfo();
        Vague vague = new Vague();
        Page<SosInfo> page = new Page<>(1,10);
        vague.setSosId(sosId);
        Page<SosInfo> sosInfoPage = sosInfoMapper.selectSosInfo(page,vague);
        if (sosInfoPage.getRecords() != null){
            List<VoluntaryActivityInfo> id = voluntaryActivityInfoMapper.selectMax();
            voluntaryActivityInfo.setVoluntaryActivityId(id.get(0).getMa()+1);
            if (sosInfoPage.getRecords().get(0).getSosName() != null) {
                voluntaryActivityInfo.setVoluntaryActivityName(sosInfoPage.getRecords().get(0).getSosName());
            }
            if (sosInfoPage.getRecords().get(0).getSosAddress() != null) {
                voluntaryActivityInfo.setVoluntaryActivityAddress(sosInfoPage.getRecords().get(0).getSosAddress());
            }
            if (sosInfoPage.getRecords().get(0).getSosDetailedInformation() != null) {
                voluntaryActivityInfo.setVoluntaryActivityDetailedInformation(sosInfoPage.getRecords().get(0).getSosDetailedInformation());
            }
            int result = voluntaryActivityInfoMapper.insert(voluntaryActivityInfo);
            if (result>0) {
                jsonResult = jsonResult.requestSuccess(result);
            }
        }else {
            jsonResult = jsonResult.resultFail("发布失败");
        }
        return jsonResult;
    }

    /**
     * 设置为已处理
     * @param sosId
     * @return
     */
    @Override
    public JsonResult updateSosStatus(Integer sosId) {
        int result = sosInfoMapper.updateSosStatus(sosId);
        JsonResult jsonResult = new JsonResult();
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("设置失败");
        }
        return jsonResult;
    }

    /**
     * 保存暂返信息
     * @param sosId
     * @param sosReply
     * @return
     */
    @Override
    public JsonResult updateSosReply(Integer sosId, String sosReply) {
        int result = sosInfoMapper.updateSosReply(sosId,sosReply);
        JsonResult jsonResult = new JsonResult();
        if (result > 0){
            sosInfoMapper.deleteSosInfo(sosId);
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("设置失败");
        }
        return jsonResult;
    }
}
