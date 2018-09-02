package com.example.nanqingtest.controller;

import com.example.nanqingtest.common.JsonResult;
import com.example.nanqingtest.model.domain.ArticleNewContent;
import com.example.nanqingtest.model.entity.ArticleT;
import com.example.nanqingtest.service.ArticleNewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("articlet")
public class ArticleNewController {
    private final Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private ArticleNewService articleNewService;

    @GetMapping("downloadlist")
    public Object downloadlist( @RequestParam("page")Integer page,@RequestParam("pagesize")Integer pagesize)//@RequestBody中的数据以键值对形式存在
    {
        List<ArticleT> a = articleNewService.getPage(page,pagesize);
        return JsonResult.ok(a);
    }

    @GetMapping("downloadlist/downloaddetail")
    public Map downloaddetail(@RequestParam("id") Integer id) {
        try {
            ArticleNewContent content = articleNewService.getArticleDetail(id);
            return JsonResult.ok(content);
        } catch (Exception e) {
            logger.error("详情页查询出错",e);
            e.printStackTrace();
            return JsonResult.fail("查询出错");
        }


    }
}
