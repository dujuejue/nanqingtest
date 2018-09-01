package com.example.nanqingtest.service;

import com.example.nanqingtest.dao.mapper.ArticleContentMapper;
import com.example.nanqingtest.dao.mapper.ArticleTMapper;
import com.example.nanqingtest.model.domain.ArticleNewContent;
import com.example.nanqingtest.model.domain.ArticlePartResponse;
import com.example.nanqingtest.model.entity.ArticleContent;
import com.example.nanqingtest.model.entity.ArticleT;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleNewService {
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private ArticleTMapper articleTMapper;

    public ArticleNewContent getArticleDetail(Integer id) {
        ArticleNewContent articleNewContent = new ArticleNewContent();//ArticleNewContent实例
        ArticleT articleT = articleTMapper.selectByPrimaryKey(id);//获得article_t(id, title, cover)
        List<ArticleContent> articleContentList = articleContentMapper.getByArticleId(id);//获得article_content(id, `type`, `value`, article_id, sort)
        List<ArticlePartResponse> responseList = new ArrayList<>();//获得包含type,value的List
        BeanUtils.copyProperties(articleT, articleNewContent);//将article_t复制进articleT实例
        for (ArticleContent a : articleContentList) {
            ArticlePartResponse articlePartResponse = new ArticlePartResponse();
            BeanUtils.copyProperties(a, articlePartResponse);//将ArticleContent对象实例的数据复制进articlePartResponse实例
            responseList.add(articlePartResponse);//给responseList赋值
        }
        articleNewContent.setContent(responseList);
        return articleNewContent;
    }

    public List<ArticleT> getPage(int currPage, int pageSize) {
        int currentIndex=currPage*pageSize;//Mysql limit中的第一个参数和Mybatis中limit第一个参数有区别
        List<ArticleT> articleTList= articleTMapper.querytitleBySql(currentIndex,pageSize);
        return articleTList;
    }


}
