package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.UserInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.mapper.UserInfoMapper;
import com.ztc.strayanimal.service.UserInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 模糊查询用户
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult selectUserInfo(Vague vague, Integer pageSize, Integer current) {
        if (vague == null){
            vague = new Vague();
        }
        JsonResult jsonResult = new JsonResult();
        Page<UserInfo> page = new Page<>(current,pageSize);
        Page<UserInfo> userInfoPage = userInfoMapper.selectUserInfo(page,vague);
        if (userInfoPage.getRecords() != null){
            for (int i = 0;i < userInfoPage.getRecords().size();i++){
                String strCreateTime = new SimpleDateFormat("yyyy-MM-dd").format(userInfoPage.getRecords().get(i).getCreateTime());
                userInfoPage.getRecords().get(i).setStrCreateTime(strCreateTime);
            }
            jsonResult = jsonResult.requestSuccess((List)userInfoPage.getRecords());
            jsonResult.setCountSize((int)userInfoPage.getTotal());
        }else {
            jsonResult = jsonResult.resultFail("请求失败");
        }
        return jsonResult;
    }

    /**
     * 查看详情
     * @param userId
     * @return
     */
    @Override
    public JsonResult selectUser(Long userId) {
        JsonResult jsonResult = new JsonResult();
        UserInfo userInfo = userInfoMapper.selectUser(userId);
        if (userInfo != null){
            if (userInfo.getUserBirthday() != null){
                userInfo.setStrUserBirthday(new SimpleDateFormat("yyyy-MM-dd").format(userInfo.getUserBirthday()));
            }
            userInfo.setStrCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(userInfo.getCreateTime()));
            userInfo.setStrUpdateTime(new SimpleDateFormat("yyyy-MM-dd").format(userInfo.getUpdateTime()));
            jsonResult = jsonResult.requestSuccess(userInfo);
        }else {
            jsonResult = jsonResult.resultFail("操作失败");
        }
        return jsonResult;
    }

    /**
     * 登录
     * @param userAccount
     * @return
     */
    @Override
    public JsonResult selectUserAccount(String userAccount,String userPassword) {
        JsonResult jsonResult = new JsonResult();
        UserInfo userInfo = userInfoMapper.selectUserAccount(userAccount);
        if(userInfo == null){
            jsonResult = jsonResult.resultFail("此手机号还没注册过哦");
        }else{
            if (userInfo.getUserPassword().equals(userPassword)){
                jsonResult = jsonResult.requestSuccess(userInfo);
            }else {
                jsonResult = jsonResult.resultFail("手机号或密码错误");
            }
        }
        return jsonResult;
    }

    /**
     * 注册
     * @param userInfo
     * @return
     */
    @Override
    public JsonResult addUser(UserInfo userInfo) {
        JsonResult jsonResult = new JsonResult();
        UserInfo userInfo1 = userInfoMapper.selectUserAccount(userInfo.getUserAccount());
        if(userInfo1 == null){
            int result = userInfoMapper.insert(userInfo);
            if (result > 0){
                jsonResult = jsonResult.requestSuccess("成功");
            }else {
                jsonResult = jsonResult.resultFail("注册失败");
            }
        }else {
            jsonResult = jsonResult.resultFail("该手机号已经注册过了");
        }

        return jsonResult;
    }

    /**
     * 逻辑删除（注销）
     * @param userId
     * @return
     */
    @Override
    public JsonResult deleteUserInfo(Long userId) {
        JsonResult jsonResult = new JsonResult();
        int result = userInfoMapper.deleteUserInfo(userId);
        if (result > 0){
            jsonResult = jsonResult.requestSuccess(null);
        }else {
            jsonResult = jsonResult.resultFail("注销失败");
        }
        return jsonResult;
    }
}
