package com.example.nanqingtest.dao.mapper;

import com.example.nanqingtest.model.entity.ArticleT;
import java.util.List;

public interface ArticleTMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleT record);

    ArticleT selectByPrimaryKey(Integer id);

    List<ArticleT> selectAll();

    int updateByPrimaryKey(ArticleT record);
}