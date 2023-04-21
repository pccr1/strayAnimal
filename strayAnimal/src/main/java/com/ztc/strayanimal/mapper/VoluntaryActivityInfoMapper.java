package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VoluntaryActivityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoluntaryActivityInfoMapper extends BaseMapper<VoluntaryActivityInfo> {


    /**
     * 导出志愿活动信息
     * 45@return
     */
    List<VoluntaryActivityInfo> exportVoluntaryActivityInfo();


    /**
     * 模糊查询志愿活动
     * @param page
     * @param vague
     * @return
     */
    Page<VoluntaryActivityInfo> selectVoluntaryActivityInfo(@Param("page") Page<VoluntaryActivityInfo> page,
                                                            @Param("vag")Vague vague);

    /**
     * 查看详情 活动详细信息
     * @param voluntaryActivityId
     * @return
     */
    List<VoluntaryActivityInfo> selectVoluntaryActivityDetailedInformation(@Param("voluntaryActivityId") Long voluntaryActivityId);

    /**
     * 查看参加活动的志愿者
     * @param voluntaryActivityId
     * @return
     */
    List<VoluntaryActivityInfo> selectVolunteer(@Param("voluntaryActivityId") Long voluntaryActivityId);

    /**
     * 查询无志愿者数据的原始志愿活动信息
     * @param voluntaryActivityId
     * @return
     */
    VoluntaryActivityInfo selectTary(Long voluntaryActivityId);

    /**
     * 查询志愿者ID对应姓名
     * @param volunteerId
     * @return
     */
    List<VoluntaryActivityInfo> selectTeer(@Param("volunteerId") Long volunteerId);

    /**
     * 删除志愿活动
     * @param voluntaryActivityId
     * @return
     */
    int deleteVoluntaryActivity(Long voluntaryActivityId);

    /**
     * 删除参加该志愿活动的志愿者
     * @param voluntaryActivityId
     * @param volunteerId
     * @return
     */
    int deleteVolunteer(Long voluntaryActivityId,Long volunteerId);

    /**
     * 查询最大的志愿活动ID
     * @return
     */
    List<VoluntaryActivityInfo> selectMax();
}
