package com.ztc.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztc.strayanimal.entiy.AnimalInfo;
import com.ztc.strayanimal.entiy.ExportAnimal;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.util.JsonResult;

import java.util.List;

public interface AnimalInfoService extends IService<AnimalInfo> {

    /**
     * 查询小动物
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    public JsonResult getAllAnimal(Vague vague,Integer pageSize,Integer current);

    /**
     * 导出当前页信息为Excel表格
     * @param vague
     * @param pageSize
     * @param current
     */
    public List<ExportAnimal> exportAnimalData(Vague vague, Integer pageSize, Integer current);

    /**
     * 删除小动物
     * @param animalId
     * @return
     */
    public JsonResult deleteAnimal(Long animalId);
    /**
     * 领养信息 查看详情
     */
    public JsonResult selectAdoptInfo(Long userId,Long animalId);
    /**
     * 领养信息查询
     */
    public JsonResult selectAdoptInfos(Integer pageCurrent,Integer pageSize,String animalAdoption);

    /**
     * 添加小动物信息
     * @param animalInfo
     * @return
     */
    public JsonResult addAnimalInfo(AnimalInfo animalInfo);

    /**
     * 修改小动物信息
     * @param animalInfo
     * @return
     */
    public JsonResult updateAnimalInfo(AnimalInfo animalInfo);

    /**
     * 小动物信息 查看详情
     * @param animalId
     * @return
     */
    public JsonResult selectAnimals(Long animalId);
}
