package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.UserInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.util.JsonResult;

public interface UserInfoService extends IService<UserInfo> {

    /**
     * 模糊查询用户
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult selectUserInfo(Vague vague,Integer pageSize,Integer current);

    /**
     * 查看详情
     * @param userId
     * @return
     */
    public JsonResult selectUser(Long userId);

    /**
     * 登录
     * @param userAccount
     * @return
     */
    public JsonResult selectUserAccount(String userAccount,String userPassword);

    /**
     * 注册
     * @param userInfo
     * @return
     */
    public JsonResult addUser(UserInfo userInfo);

    /**
     * 逻辑删除（注销）
     * @param userId
     * @return
     */
    public JsonResult deleteUserInfo(Long userId);
}
