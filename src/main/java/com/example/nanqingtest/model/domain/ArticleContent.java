package com.example.nanqingtest.model.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ArticleContent {
    private String author;
    private Date createTime;
    private List<String> content;
    private List<String> imageUrl;
}
