package com.ztc.strayanimal.entiy;

import lombok.Data;

/**
 * 前端模糊查询字段
 */
@Data
public class Vague {

    private String animalAdoption;//领养状态

    private Long animalId;//流浪动物ID

    private String animalName;//动物名字

    private String species;//物种

    private String voluntaryActivityName;//活动名称

    private String userRealname;//用户真实姓名

    private String status;//活动状态

    private Integer sosId;//紧急救助ID

    private String sosStatus;//处理状态(未处理 处理中 已完成)

    private String userPhone;//用户电话

    private Long volunteerId;//志愿者ID

    private String rescueStationName;//救助站名称

    private String rescueStationPrincipal;//救助站负责人

    private Long userId;//用户ID

    private String userAccount;//用户账号
}
