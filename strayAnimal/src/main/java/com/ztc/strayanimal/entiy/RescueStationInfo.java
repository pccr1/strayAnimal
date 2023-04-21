package com.ztc.strayanimal.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("rescue_station_info")
public class RescueStationInfo {

    @TableId("rescue_station_id")
    private Long rescueStationId;//救助站ID

    private String rescueStationName;//救助站名称

    private Integer rescueStationCapacity;//救助站容量

    private Integer rescueCurrentCapacity;//目前容纳数

    private String rescueStationAddress;//救助站地址

    private String rescueStationPrincipal;//救助站负责人

    private String rescueStationPhone;//救助站联系方式

    private String rescueStationPicture;//救助站照片

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//修改时间

    @TableLogic
    private Integer isDelete;//逻辑删除
}
