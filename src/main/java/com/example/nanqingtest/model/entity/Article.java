package com.example.nanqingtest.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter
@ToString
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String  author;

    private Date createTime;

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Image> imageList;

    @OneToMany(mappedBy ="article",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ArticlePart> articlePartList;

}
