package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.strayanimal.entiy.UserInfo;
import com.ztc.strayanimal.entiy.Vague;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 模糊查询用户
     * @param page
     * @param vague
     * @return
     */
    Page<UserInfo> selectUserInfo(@Param("page") Page<UserInfo> page,
                                  @Param("vag")Vague vague);

    /**
     * 查看详情
     * @param userId
     * @return
     */
    UserInfo selectUser(Long userId);

    /**
     * 登录
     * @param userAccount
     * @return
     */
    UserInfo selectUserAccount(String userAccount);

    /**
     * 逻辑删除
     * @param userId
     * @return
     */
    int deleteUserInfo(Long userId);
}
