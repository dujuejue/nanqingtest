package com.example.nanqingtest.dao.mapper;

import com.example.nanqingtest.model.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Image record);

    Image selectByPrimaryKey(Integer id);

    List<Image> selectAll();

    int updateByPrimaryKey(Image record);

    List<String> selectByByArticleId(@Param("articleId")Integer articleId);
}