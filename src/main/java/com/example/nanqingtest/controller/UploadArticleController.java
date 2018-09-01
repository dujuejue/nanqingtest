package com.example.nanqingtest.controller;

import com.example.nanqingtest.common.JsonResult;
import com.example.nanqingtest.model.domain.ArticleNewContent;
import com.example.nanqingtest.service.UploadNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("upload/article")
public class UploadArticleController
{
    @Autowired
    private UploadNewService uploadNewService;
    @PostMapping("content")
    public Object upload(@RequestBody ArticleNewContent content)
    {
        uploadNewService.uploadDetail(content);
        return JsonResult.ok();
    }
}
