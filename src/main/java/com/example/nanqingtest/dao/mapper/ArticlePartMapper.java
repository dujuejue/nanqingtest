package com.example.nanqingtest.dao.mapper;

import com.example.nanqingtest.model.entity.ArticlePart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ArticlePartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticlePart record);

    ArticlePart selectByPrimaryKey(Integer id);

    List<ArticlePart> selectAll();

    int updateByPrimaryKey(ArticlePart record);

    List<String> selectByArticleId(@Param("articleId") Integer articleId);
}