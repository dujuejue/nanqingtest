package com.example.nanqingtest.model.domain;

import com.example.nanqingtest.model.entity.ArticleT;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class ArticleNewContent {
    private String title;
    private String cover;
    private List<ArticlePartResponse> content;
}
