package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztc.strayanimal.entiy.AnswerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerInfoMapper extends BaseMapper<AnswerInfo> {

    /**
     * 回复预览
     * @param commentId
     * @return
     */
    List<AnswerInfo> selectAnswerInfo(@Param("commentId")Long commentId);

    /**
     * 回复删除
     */
    int deleteAnswerInfo(Long answerId);
}
