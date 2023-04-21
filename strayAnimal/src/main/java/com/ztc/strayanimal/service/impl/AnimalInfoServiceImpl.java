package com.ztc.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.strayanimal.entiy.AnimalInfo;
import com.ztc.strayanimal.entiy.ExportAnimal;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.mapper.AnimalInfoMapper;
import com.ztc.strayanimal.service.AnimalInfoService;
import com.ztc.strayanimal.util.JsonResult;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AnimalInfoServiceImpl extends ServiceImpl<AnimalInfoMapper, AnimalInfo> implements AnimalInfoService {

    @Resource
    private AnimalInfoMapper animalInfoMapper;

    /**
     * 查询小动物
     *
     * @param vague
     * @param pageSize
     * @param current
     * @return
     */
    @Override
    public JsonResult getAllAnimal(Vague vague, Integer pageSize, Integer current) {
        if (vague == null) {
            vague = new Vague();
        }
        JsonResult jsonResult = new JsonResult();
        Page<AnimalInfo> page = new Page<>(current, pageSize);
        Page<AnimalInfo> animalInfos = animalInfoMapper.selectAnimal(page, vague);
        if (animalInfos.getRecords() != null) {
            jsonResult = jsonResult.requestSuccess((List) animalInfos.getRecords());
            jsonResult.setCountSize((int) animalInfos.getTotal());

        } else {
            jsonResult.resultFail("请求失败");
        }

        return jsonResult;
    }

    @Override
    public  List<ExportAnimal> exportAnimalData(Vague vague, Integer pageSize, Integer current) {
        if (vague == null) {
            vague = new Vague();
        }
        Page<ExportAnimal> page = new Page<>(current, pageSize);
        Page<ExportAnimal> thisPageAllAnilmalsInfo = animalInfoMapper.getThisPageAllAnilmalsInfo(page, vague);
        List<ExportAnimal> records = thisPageAllAnilmalsInfo.getRecords();
        return  records;

    }

    /**
     * 删除小动物
     *
     * @param animalId
     * @return
     */
    @Override
    public JsonResult deleteAnimal(Long animalId) {
        JsonResult jsonResult = new JsonResult();
        int result = animalInfoMapper.deleteAnimalInfo(animalId);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("删除失败！");
        }
        return jsonResult;
    }

    /**
     * 领养信息 查看详情
     */
    @Override
    public JsonResult selectAdoptInfo(Long userId, Long animalId) {
        List<AnimalInfo> result = animalInfoMapper.selectAdoptInfo(userId, animalId);
        JsonResult jsonResult = new JsonResult();
        for (int i = 0; i < result.size(); i++) {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.get(i).getCreateTime());
            result.get(i).setStrCreateTime(format);
        }
        if (result.size() > 0) {
            jsonResult = jsonResult.requestSuccess(result);
        } else {
            jsonResult = jsonResult.resultFail("没有数据");
        }
        return jsonResult;
    }

    /**
     * 领养信息查询
     */
    @Override
    public JsonResult selectAdoptInfos(Integer pageCurrent, Integer pageSize, String animalAdoption) {
        Page<AnimalInfo> page = new Page<>(pageCurrent, pageSize);
        Page<AnimalInfo> page1 = animalInfoMapper.selectAdoptInfos(page, animalAdoption);
        JsonResult jsonResult = new JsonResult();
        if (page1.getRecords() != null) {
            jsonResult = jsonResult.requestSuccess(page1.getRecords());
            jsonResult.setCountSize((int) page1.getTotal());
            return jsonResult;
        }
        return new JsonResult().resultFail("没有找到对应数据");
    }

    /**
     * 添加小动物信息
     *
     * @param animalInfo
     * @return
     */
    @Override
    public JsonResult addAnimalInfo(AnimalInfo animalInfo) {
        int result = animalInfoMapper.insert(animalInfo);
        JsonResult jsonResult = new JsonResult();
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("添加失败！");
        }
        return jsonResult;
    }

    /**
     * 修改小动物信息
     *
     * @param animalInfo
     * @return
     */
    public JsonResult updateAnimalInfo(AnimalInfo animalInfo) {
        JsonResult jsonResult = new JsonResult();
        int result = animalInfoMapper.updateById(animalInfo);
        if (result > 0) {
            jsonResult = jsonResult.requestSuccess(null);
        } else {
            jsonResult = jsonResult.resultFail("更新失败！");
        }
        return jsonResult;
    }

    /**
     * 小动物们 查看详情
     *
     * @param animalId
     * @return
     */
    @Override
    public JsonResult selectAnimals(Long animalId) {
        List<AnimalInfo> result = animalInfoMapper.selectAnimals(animalId);
        JsonResult jsonResult = new JsonResult();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getVaccinationTime() != null) {
                String format1 = new SimpleDateFormat("yyyy-MM-dd").format(result.get(i).getVaccinationTime());
                result.get(i).setStrVaccinationTime(format1);
            }
            if (result.get(i).getSterilizationTime() != null) {
                String format2 = new SimpleDateFormat("yyyy-MM-dd").format(result.get(i).getSterilizationTime());
                result.get(i).setStrSterilizationTime(format2);
            }
            if (result.get(i).getRepellentTime() != null) {
                String format3 = new SimpleDateFormat("yyyy-MM-dd").format(result.get(i).getRepellentTime());
                result.get(i).setStrRepellentTime(format3);
            }
            if (result.get(i).getAnimalAdoptionTime() != null) {
                String format4 = new SimpleDateFormat("yyyy-MM-dd").format(result.get(i).getAnimalAdoptionTime());
                result.get(i).setStrAnimalAdoptionTime(format4);
            }
            String format5 = new SimpleDateFormat("yyyy-MM-dd").format(result.get(i).getCreateTime());
            String format6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.get(i).getUpdateTime());
            result.get(i).setStrCreateTime(format5);
            result.get(i).setStrUpdateTime(format6);
        }
        if (result.size() > 0) {
            jsonResult = jsonResult.requestSuccess(result);
        } else {
            jsonResult = jsonResult.resultFail("没有数据");
        }
        return jsonResult;
    }
}
