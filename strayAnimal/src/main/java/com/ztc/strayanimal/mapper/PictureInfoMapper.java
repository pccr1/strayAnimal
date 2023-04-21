package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.strayanimal.entiy.PictureInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureInfoMapper extends BaseMapper<PictureInfo> {

    /**
     * 根据ID查询照片
     * @param pictureInfo
     * @return
     */
    List<PictureInfo> selectPictureInfo(@Param("pi")PictureInfo pictureInfo);

    /**
     * 照片删除
     */
    int deletePictureInfo(Long PictureId);
}
