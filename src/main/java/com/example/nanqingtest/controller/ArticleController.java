package com.example.nanqingtest.controller;

import com.example.nanqingtest.common.JsonResult;
import com.example.nanqingtest.model.domain.ArticleContent;
import com.example.nanqingtest.model.entity.Article;
import com.example.nanqingtest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
    public Object getContent(@PathVariable("id") Integer id) {
        ArticleContent articleContent =articleService.getContetnt(id);
        return JsonResult.ok(articleContent);
    }
}
