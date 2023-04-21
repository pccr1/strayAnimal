package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.AnswerInfo;
import com.ztc.strayanimal.mapper.AnswerInfoMapper;
import com.ztc.strayanimal.service.AnswerInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AnswerInfoServiceImpl extends ServiceImpl<AnswerInfoMapper, AnswerInfo> implements AnswerInfoService {

    @Resource
    private AnswerInfoMapper answerInfoMapper;

    /**
     * 回复预览
     * @param commentId
     * @return
     */
    @Override
    public JsonResult selectAnswerInfo(Long commentId) {
        List<AnswerInfo> result = answerInfoMapper.selectAnswerInfo(commentId);
        JsonResult jsonResult = new JsonResult();
        for (int i = 0; i < result.size(); i++) {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.get(i).getCreateTime());
            result.get(i).setStrCreateTime(format);
        }
        if (result.size() > 0) {
            jsonResult = jsonResult.requestSuccess(result);
        } else {
            jsonResult = jsonResult.resultFail("没有数据");
        }
        return jsonResult;
    }

    /**
     * 回复删除
     */
    @Override
    public JsonResult deleteAnswerInfo(Long answerId) {
        JsonResult jsonResult = new JsonResult();
        int result = answerInfoMapper.deleteAnswerInfo(answerId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("删除失败！");
        }
        return jsonResult;
    }
}
