package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.PictureInfo;
import com.ztc.strayanimal.util.JsonResult;

public interface PictureInfoService extends IService<PictureInfo> {

    /**
     * 根据帖子ID查询照片
     * @param pictureInfo
     * @return
     */
    public JsonResult selectPictureInfo(PictureInfo pictureInfo);

    /**
     * 添加照片
     * @param pictureInfo
     * @return
     */
    public JsonResult addPicture(PictureInfo pictureInfo);

    /**
     * 照片删除
     * @param PictureId
     * @return
     */
    public JsonResult deletePictureInfo(Long PictureId);
}
