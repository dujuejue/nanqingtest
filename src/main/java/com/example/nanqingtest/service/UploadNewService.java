package com.example.nanqingtest.service;

import com.example.nanqingtest.dao.mapper.ArticleContentMapper;
import com.example.nanqingtest.dao.mapper.ArticleTMapper;
import com.example.nanqingtest.model.domain.ArticleNewContent;
import com.example.nanqingtest.model.domain.ArticlePartResponse;
import com.example.nanqingtest.model.entity.ArticleContent;
import com.example.nanqingtest.model.entity.ArticleT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UploadNewService
{
    @Autowired
    private ArticleTMapper articleTMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    public void uploadDetail(ArticleNewContent content)
    {
        ArticleT articleT = new ArticleT();
        BeanUtils.copyProperties(content, articleT);
        articleT.setCreateTime(new Date());
        articleTMapper.insert(articleT);
        List<ArticlePartResponse> articlePartResponseList = content.getContent();
        int sort = 0;
        for (ArticlePartResponse part : articlePartResponseList)
        {
            ArticleContent articleContent = new ArticleContent();
            BeanUtils.copyProperties(part, articleContent);
            articleContent.setArticleId(articleT.getId());
            articleContent.setSort(sort++);
            articleContentMapper.insert(articleContent);
        }
    }
}
