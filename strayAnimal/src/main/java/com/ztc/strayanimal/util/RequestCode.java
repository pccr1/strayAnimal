package com.ztc.strayanimal.util;

/**
 * 状态码枚举类
 */
public enum RequestCode {
    REQUEST_SUCCESS("1"),//请求成功时状态码
    REQUEST_FAIL("0");//请求失败时状态码
    private  String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    RequestCode(String code) {
        this.code = code;
    }
}
