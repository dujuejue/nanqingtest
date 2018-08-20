package com.example.nanqingtest.controller;

import com.example.nanqingtest.common.JsonResult;
import com.example.nanqingtest.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

@RestController
@RequestMapping("article")
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UploadService uploadService;


//    //跳转到上传文件的页面
//    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
//    public String goUploadImg() {
//        //跳转到 templates 目录下的 uploadimg.html
//        return "uploadimg";
//    }

    //处理图片上传
    @PostMapping("uploadimg")
    public Object uploadImg(@RequestParam("file") MultipartFile file) {
        try {
            uploadService.uploadImage(file);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return JsonResult.fail(e.toString());
        }
        return JsonResult.ok();
    }


    @PostMapping("uploadtext")
    public Object uploadText(@RequestBody Map params) {
        try {
            String text= (String) params.get("context");
            uploadService.uploadText(text);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return JsonResult.fail(e.toString());
        }
        return JsonResult.ok();
    }


    @PostMapping("uploadarticle")
    public Object uploadArticle(@RequestBody Map params) {
        try {
            String author= (String) params.get("author");
            uploadService.saveArticle(author);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return JsonResult.fail(e.toString());
        }
        return JsonResult.ok();
    }
}
