package com.example.nanqingtest.dao;

import com.example.nanqingtest.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image,Integer> {
}
