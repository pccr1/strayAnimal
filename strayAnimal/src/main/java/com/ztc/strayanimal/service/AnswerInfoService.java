package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.AnswerInfo;
import com.ztc.strayanimal.util.JsonResult;

public interface AnswerInfoService extends IService<AnswerInfo> {

    /**
     * 回复预览
     * @param commentId
     * @return
     */
    public JsonResult selectAnswerInfo(Long commentId);

    /**
     * 回复删除
     */
    public JsonResult deleteAnswerInfo(Long answerId);
}
