package com.ztc.strayanimal.util;

import lombok.Data;

import static com.ztc.strayanimal.util.RequestCode.REQUEST_FAIL;
import static com.ztc.strayanimal.util.RequestCode.REQUEST_SUCCESS;

/**
 * 通用返回结果
 */
@Data
public class JsonResult {

    private Boolean success;//是否成功

    private String code; // 校验码

    private String message; //返回信息

    private Object object;//返回数据

    private Integer countSize;//总条数

    /**
     * 响应成功的返回
     *
     * @return
     */
    public JsonResult requestSuccess(Object object) {
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setCode(REQUEST_SUCCESS.getCode());
//        jsonResult.setObject(object);
//        jsonResult.setSuccess(true);
//        return jsonResult;
        this.code = REQUEST_SUCCESS.getCode();
        this.object = object;
        this.success = true;
        return this;
    }

    public JsonResult resultFail(String message) {
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setCode(REQUEST_FAIL.getCode());
//        jsonResult.setMessage(message);
//        jsonResult.setSuccess(false);
//        return jsonResult;
        this.code = REQUEST_FAIL.getCode();
        this.message = message;
        this.success = false;
        return this;
    }

}
