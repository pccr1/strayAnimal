package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.UserInfo;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.service.UserInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@ResponseBody
@RequestMapping("/user/info")
@CrossOrigin("*")
public class UserController{

    @Resource
    private UserInfoService userInfoService;

    /**
     * 模糊查询用户
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @PostMapping("/selectUserInfo")
    public JsonResult selectUserInfo(@ModelAttribute Vague vague,
                                     @RequestParam(required = false,defaultValue = "10")Integer pageSize,
                                     @RequestParam(required = false,defaultValue = "1")Integer current){
        return userInfoService.selectUserInfo(vague,pageSize,current);
    }

    /**
     * 查看详情
     * @param userId
     * @return
     */
    @PostMapping("/selectUser")
    public JsonResult selectUser(@RequestParam Long userId){
        return userInfoService.selectUser(userId);
    }

    /**
     * 登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    @PostMapping("/selectUserAccount")
    public JsonResult selectUserAccount(@RequestParam String userAccount,
                                        @RequestParam String userPassword){
        return userInfoService.selectUserAccount(userAccount,userPassword);
    }

    /**
     * 注册
     * @param userInfo
     * @return
     */
    @PostMapping("/addUser")
    public JsonResult addUser(@ModelAttribute UserInfo userInfo){
        return userInfoService.addUser(userInfo);
    }

    /**
     * 逻辑删除（注销）
     * @param userId
     * @return
     */
    @PostMapping("/deleteUserInfo")
    public JsonResult deleteUserInfo(@RequestParam Long userId){
        return userInfoService.deleteUserInfo(userId);
    }
}
