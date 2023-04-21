package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import com.ztc.strayanimal.util.ExcelExport;
import lombok.Data;

import java.util.Date;

@Data
@TableName("animal_info")
public class AnimalInfo {

    @TableId("animal_id")

    private Long animalId;//流浪动物ID


    private String animalName;//动物名字

    private String animalPictures;//动物照片


    private String animalSex;//动物性别


    private String animalAge;//动物年龄

    private Long animalRescueStationId;//所属救助站


    private String species;//物种


    private String varieties;//品种

    private String vaccination;//是否接种

    private Date vaccinationTime;//接种时间

    private String sterilization;//是否绝育

    private Date sterilizationTime;//绝育时间

    private String repellent;//是否驱虫


    private Date repellentTime;//驱虫时间

    private String animalAdoption;//领养状态

    private Long userId;//领养人ID

    private Date animalAdoptionTime;//领养时间

    private String adoptionNotes;//领养备注

    private String detailedInformation;//详细信息


    @TableField(exist = false)
    private String userRealname;

    @TableField(exist = false)
    private String userPhone;

    @TableField(exist = false)
    private String userAddress;

    @TableField(exist = false)
    private String userEmail;
    @TableField(exist = false)
    private String rescueStationName;
    @TableField(exist = false)
    private String strVaccinationTime;//接种时间str
    @TableField(exist = false)
    private String strSterilizationTime;//绝育时间str
    @TableField(exist = false)
    private String strRepellentTime;//驱虫时间str
    @TableField(exist = false)
    private String strAnimalAdoptionTime;//领养时间str
    @TableField(exist = false)
    private String strCreateTime;
    @TableField(exist = false)
    private String strUpdateTime;
    @TableField(exist = false)
    private String animalRescueStationName;//救助站名


    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
