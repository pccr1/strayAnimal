package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.strayanimal.entiy.SosInfo;
import com.ztc.strayanimal.entiy.Vague;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SosInfoMapper extends BaseMapper<SosInfo> {

    /**
     * 下拉菜单 发布成志愿活动
     * @param page
     * @param vague
     * @return
     */
    Page<SosInfo> selectSosInfo(@Param("page") Page<SosInfo> page,
                                @Param("vag")Vague vague);

    /**
     * 设置为已处理
     * @param sosId
     * @return
     */
    int updateSosStatus(Integer sosId);

    /**
     * 保存暂返信息
     * @param sosId
     * @param sosReply
     * @return
     */
    int updateSosReply(Integer sosId,String sosReply);

    /**
     * 逻辑删除
     * @param sosId
     * @return
     */
    int deleteSosInfo(Integer sosId);
}
