package com.example.nanqingtest.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@Getter
@Setter
@ToString
public class Article {
    @Id
    @GeneratedValue
    private Integer id;

    private String contentText;

    private String imageUrl;

    private String coverUrl;

}
