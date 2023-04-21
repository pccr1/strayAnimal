package com.ztc.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztc.strayanimal.entiy.AnimalInfo;
import com.ztc.strayanimal.entiy.ExportAnimal;
import com.ztc.strayanimal.entiy.Vague;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnimalInfoMapper extends BaseMapper<AnimalInfo> {



    /**
     * 查询当前页小动物信息，包裹
     * @param page
     * @param vague
     * @return
     */
    Page<ExportAnimal>  getThisPageAllAnilmalsInfo(@Param("page") Page<ExportAnimal> page, @Param("vag") Vague vague);

    /**
     * 查询小动物
     * @param
     * @param
     * @return
     */
    Page<AnimalInfo> selectAnimal(@Param("page") Page<AnimalInfo> page,
                                          @Param("vag")Vague vague);

    /**
     * 小动物删除
     */
    int deleteAnimalInfo(Long animalId);

    /**
     * 领养信息 查看详情
     */
    List<AnimalInfo> selectAdoptInfo(@Param("userId")Long userId,
                                     @Param("animalId")Long animalId);

    /**
     * 领养信息查询
     */
    Page<AnimalInfo> selectAdoptInfos(@Param("page") Page<AnimalInfo> page,
                                     @Param("animalAdoption")String animalAdoption);

    /**
     * 小动物信息 查看详情
     * @param animalId
     * @return
     */
    List<AnimalInfo> selectAnimals(@Param("animalId")Long animalId);
}
