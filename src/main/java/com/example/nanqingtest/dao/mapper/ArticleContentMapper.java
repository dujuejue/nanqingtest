package com.example.nanqingtest.dao.mapper;

import com.example.nanqingtest.model.domain.ArticleNewContent;
import com.example.nanqingtest.model.entity.ArticleContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContent record);

    ArticleContent selectByPrimaryKey(Integer id);

    List<ArticleContent> selectAll();

    int updateByPrimaryKey(ArticleContent record);

    List<ArticleContent> getByArticleId(@Param("articleId") Integer articleId);
}