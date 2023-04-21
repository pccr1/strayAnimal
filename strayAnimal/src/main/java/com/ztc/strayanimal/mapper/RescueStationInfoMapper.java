package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.strayanimal.entiy.RescueStationInfo;
import com.ztc.strayanimal.entiy.Vague;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RescueStationInfoMapper extends BaseMapper<RescueStationInfo> {

    /**
     * 模糊查询救助站
     * @param page
     * @param vague
     * @return
     */
    Page<RescueStationInfo> selectRescueStationInfo(@Param("page") Page<RescueStationInfo> page,
                                                    @Param("vag") Vague vague);

    /**
     * 逻辑删除
     * @param rescueStationId
     * @return
     */
    int deleteRescueStationInfo(Long rescueStationId);
}
