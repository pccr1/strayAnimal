package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.entiy.AnimalInfo;
import com.ztc.strayanimal.entiy.ExportAnimal;
import com.ztc.strayanimal.entiy.Vague;
import com.ztc.strayanimal.service.AnimalInfoService;
import com.ztc.strayanimal.util.ExcelUtils;
import com.ztc.strayanimal.util.JsonResult;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/animal/info")
@CrossOrigin("*")
public class AnimalController {

    @Resource
    private AnimalInfoService animalInfoService;

    /**
     * 查询小动物
     *
     * @return
     */
    @PostMapping("/getAllAnimalInfo")
    public JsonResult getAllAnimalInfo(@ModelAttribute Vague vague,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false, defaultValue = "1") Integer current) {
        return animalInfoService.getAllAnimal(vague, pageSize, current);
    }

    /**
     * 删除小动物信息
     * @param animalId
     * @return
     */
    @PostMapping("/deleteAnimal")
    public JsonResult deleteAnimal(@RequestParam Long animalId) {
        return animalInfoService.deleteAnimal(animalId);
    }

    /**
     * 领养信息 查看详情
     */
    @PostMapping("/selectAdoptInfo")
    public JsonResult selectAdoptInfo(@RequestParam Long userId,
                                      @RequestParam Long animalId) {
        return animalInfoService.selectAdoptInfo(userId, animalId);
    }


    /**
     * 领养信息查询
     */
    @PostMapping("/selectAdoptInfos")
    public JsonResult selectAdoptInfos(@RequestParam(required = false, defaultValue = "1") Integer pageCurrent,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String animalAdoption) {
        return animalInfoService.selectAdoptInfos(pageCurrent, pageSize, animalAdoption);
    }

    /**
     * 添加小动物信息
     *
     * @param animalInfo
     * @return
     */
    @PostMapping("/addAnimalInfo")
    public JsonResult addAnimalInfo(@ModelAttribute AnimalInfo animalInfo) {
        return animalInfoService.addAnimalInfo(animalInfo);
    }

    /**
     * 修改小动物信息
     *
     * @param animalInfo
     * @return
     */
    @PostMapping("/updateAnimalInfo")
    public JsonResult updateAnimalInfo(@ModelAttribute AnimalInfo animalInfo) {
        return animalInfoService.updateAnimalInfo(animalInfo);
    }

    /**
     * 小动物信息 查看详情
     *
     * @param animalId
     * @return
     */
    @PostMapping("/selectAnimals")
    public JsonResult selectAnimals(@RequestParam Long animalId) {
        return animalInfoService.selectAnimals(animalId);
    }


    @GetMapping("/exportAnimalInfo")
    public void exportAnimalInfo(@ModelAttribute Vague vague, @RequestParam(required = false, defaultValue = "99999") Integer pageSize,
                                 @RequestParam(required = false, defaultValue = "1") Integer current, HttpServletResponse response) {

        List<ExportAnimal> animalInfos = animalInfoService.exportAnimalData(vague, pageSize, current);



        ExcelUtils.export(response,"动物领养信息",animalInfos,ExportAnimal.class);

    }
}
