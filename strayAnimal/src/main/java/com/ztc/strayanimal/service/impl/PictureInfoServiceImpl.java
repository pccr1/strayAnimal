package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.PictureInfo;
import com.ztc.strayanimal.entiy.PostInfo;
import com.ztc.strayanimal.mapper.PictureInfoMapper;
import com.ztc.strayanimal.service.PictureInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PictureInfoServiceImpl extends ServiceImpl<PictureInfoMapper, PictureInfo> implements PictureInfoService {

    @Resource
    private PictureInfoMapper pictureInfoMapper;

    /**
     * 根据ID查询照片
     * @param pictureInfo
     * @return
     */
    @Override
    public JsonResult selectPictureInfo(PictureInfo pictureInfo) {
        List<PictureInfo> result = pictureInfoMapper.selectPictureInfo(pictureInfo);
        JsonResult jsonResult = new JsonResult();
        if (result.size() > 0) {
            jsonResult = jsonResult.requestSuccess(result);
        } else {
            jsonResult = jsonResult.resultFail("没有照片");
        }
        return jsonResult;
    }

    /**
     * 添加照片
     * @param pictureInfo
     * @return
     */
    @Override
    public JsonResult addPicture(PictureInfo pictureInfo) {
        JsonResult jsonResult = new JsonResult();
        int result = pictureInfoMapper.insert(pictureInfo);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("添加失败！");
        }
        return jsonResult;
    }

    /**
     * 照片删除
     * @param PictureId
     * @return
     */
    @Override
    public JsonResult deletePictureInfo(Long PictureId) {
        JsonResult jsonResult = new JsonResult();
        int result = pictureInfoMapper.deletePictureInfo(PictureId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("删除失败！");
        }
        return jsonResult;
    }
}
