package com.ztc.strayanimal.entiy;


import com.ztc.strayanimal.util.ExcelExport;
import lombok.Data;

import java.util.Date;

@Data
public class ExportAnimal {

    @ExcelExport(value = "动物id")
    private Long animalId;
    @ExcelExport(value = "动物名")
    private String animalName;
    @ExcelExport(value = "动物性别")
    private String animalSex;//动物性别
    @ExcelExport(value = "动物年龄")
    private String animalAge;//动物年龄
    @ExcelExport(value = "物种")
    private String species;//物种
    @ExcelExport(value = "品种")
    private String varieties;//品种

    @ExcelExport(value = "是否接种")
    private String vaccination;//是否接种、
    @ExcelExport(value = "接种时间")
    private Date vaccinationTime;//接种时间
    @ExcelExport(value = "领养状态")
    private String animalAdoption;//领养状态
    @ExcelExport(value = "是否绝育")
    private String sterilization;//是否绝育
    @ExcelExport(value = "绝育时间")
    private Date sterilizationTime;//绝育时间
    @ExcelExport(value = "是否驱虫")
    private String repellent;//是否驱虫
    @ExcelExport(value = "驱虫时间")
    private Date repellentTime;//驱虫时间
    @ExcelExport(value = "所属救助站")
    private String rescueStationName;//救助站名
    @ExcelExport(value = "领养人ID")
    private Long userId;//领养人ID
    @ExcelExport(value = "领养人姓名")
    private String userRealname;
    @ExcelExport(value = "领养人电话")
    private String userPhone;
    @ExcelExport(value = "领养人邮箱")
    private String userEmail;
    @ExcelExport(value = "领养人地址")
    private String userAddress;

}
