package com.example.nanqingtest.dao.mapper;

import com.example.nanqingtest.model.entity.ArticleT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ArticleTMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleT record);

    ArticleT selectByPrimaryKey(Integer id);

    List<ArticleT> selectAll();

    int updateByPrimaryKey(ArticleT record);

    List<ArticleT> querytitleBySql(@Param("currIndex") Integer currIndex,@Param("pageSize") Integer pageSize);
}