package com.example.nanqingtest.model.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ArticleDto {
    private Integer id;

    private String  author;

    private Date createTime;
}
