package com.example.nanqingtest.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Getter
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "article_id")
    private Article article;
}
