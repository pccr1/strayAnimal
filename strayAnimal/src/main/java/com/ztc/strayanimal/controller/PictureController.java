package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.PictureInfo;
import com.ztc.strayanimal.service.PictureInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/picture/info")
@CrossOrigin("*")
public class PictureController {

    @Resource
    private PictureInfoService pictureInfoService;

    /**
     * 根据ID查询照片
     * @param pictureInfo
     * @return
     */
    @PostMapping("/selectPictureInfo")
    public JsonResult selectPictureInfo(@ModelAttribute PictureInfo pictureInfo) {
        return pictureInfoService.selectPictureInfo(pictureInfo);
    }

    /**
     * 添加照片
     * @param pictureInfo
     * @return
     */
    @PostMapping("/addPicture")
    public JsonResult addPicture(@ModelAttribute PictureInfo pictureInfo) {
        return pictureInfoService.addPicture(pictureInfo);
    }

    /**
     * 删除照片
     * @param PictureId
     * @return
     */
    @PostMapping("/deletePictureInfo")
    public JsonResult deletePictureInfo(@RequestParam Long PictureId) {
        return pictureInfoService.deletePictureInfo(PictureId);
    }
}
