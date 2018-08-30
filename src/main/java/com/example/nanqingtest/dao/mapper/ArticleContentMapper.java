package com.example.nanqingtest.dao.mapper;

import com.example.nanqingtest.model.entity.ArticleContent;
import java.util.List;

public interface ArticleContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContent record);

    ArticleContent selectByPrimaryKey(Integer id);

    List<ArticleContent> selectAll();

    int updateByPrimaryKey(ArticleContent record);
}