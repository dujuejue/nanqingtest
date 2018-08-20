package com.example.nanqingtest.dao;

import com.example.nanqingtest.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article,Integer> {
}
