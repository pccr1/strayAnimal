package com.ztc.strayanimal.controller;

import com.ztc.strayanimal.util.QiniuUtils;
import com.ztc.strayanimal.util.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;

    private LinkedList<File> queue = new LinkedList<>();

    @PostMapping
    public JsonResult upload(@RequestParam("image") MultipartFile file) throws IOException {
        JsonResult jsonResult = new JsonResult();
        String originalFilename = file.getOriginalFilename();
        //唯一的文件名称 使用UUID
        String fileName =  UUID.randomUUID() +"." + StringUtils.substringAfterLast(originalFilename,".");

        //将文件暂存到服务器的临时文件夹中
//        File tempFile = File.createTempFile("upload_", fileName);
//        file.transferTo(tempFile);
//
//        //将暂存的文件加入队列中
//        queue.offer(tempFile);
//
//        jsonResult.requestSuccess("文件上传成功");
//        return jsonResult;

        //上传文件 长传到哪呢？ 七牛云
        boolean upload = qiniuUtils.upload(file, fileName);
        if(upload){
            jsonResult.requestSuccess(QiniuUtils.url  + fileName);
        }else {
            jsonResult.resultFail("上传失败");
        }
        return jsonResult;
    }
//    @PostMapping("batchUpload")
//    public JsonResult batchUpload() {
//        JsonResult jsonResult = new JsonResult();
//
//        //从队列中取出所有的文件，并上传
//        while(!queue.isEmpty()) {
//            File file = queue.poll();
//            String fileName = file.getName();
//            boolean upload = qiniuUtils.upload((MultipartFile) file, fileName);
//            if(!upload){
//                jsonResult.resultFail("上传失败");
//                return jsonResult;
//            }
//        }
//
//        jsonResult.requestSuccess("所有文件上传成功");
//        return jsonResult;
//    }

}