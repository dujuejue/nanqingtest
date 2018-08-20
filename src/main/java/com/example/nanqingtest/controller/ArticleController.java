package com.example.nanqingtest.controller;

import com.example.nanqingtest.common.JsonResult;
import com.example.nanqingtest.model.entity.Article;
import com.example.nanqingtest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@RestController
@RequestMapping("article/get")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //下载图片
    @GetMapping("/image/{uri}")
    public void downloadFile(@PathVariable("uri") String fileName, HttpServletResponse response) {
        if (fileName != null) {
            articleService.getImage(fileName, response);
        }
    }

    @GetMapping("content/{id}")
    public Object getAll(@PathVariable("id") Integer id) {
        Article article=articleService.getContetnt(id);
        return JsonResult.ok(article);
    }
}
