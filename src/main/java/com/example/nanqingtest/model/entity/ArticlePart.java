package com.example.nanqingtest.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="article_part")
@Getter
@Setter
@ToString
public class ArticlePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String context;

    private Integer sort;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "article_id")
    private Article article;

}
