package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.entiy.VolunteerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VolunteerInfoMapper extends BaseMapper<VolunteerInfo> {

    /**
     * 查看申请志愿者信息
     * @param page
     * @return
     */
    Page<VolunteerInfo> selectVolunteerInfo(@Param("page") Page<VolunteerInfo> page,
                                            @Param("volunteerId") Long volunteerId);

    /**
     * 保存暂返信息
     * @param volunteerId
     * @param volunteerReply
     * @return
     */
    int updateVolunteerReply(Long volunteerId,String volunteerReply);

    /**
     * 同意成为志愿者
     * @param volunteerId
     * @return
     */
    int updateVolunteerExamineState(Long volunteerId);

    /**
     * 逻辑删除
     * @param volunteerId
     * @return
     */
    int deleteVolunteerInfo(Long volunteerId);

    /**
     * 模糊查询志愿者
     * @param page
     * @param vague
     * @return
     */
    Page<VolunteerInfo> selectVol(@Param("page") Page<VolunteerInfo> page,
                                  @Param("vag")Vague vague);

    /**
     * 志愿者 查看详情
     * @param volunteerId
     * @return
     */
    VolunteerInfo selectVolunteer(Long volunteerId);
}
