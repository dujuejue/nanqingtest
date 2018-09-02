package com.example.nanqingtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadPageController {
    @GetMapping("upload/page")
    public  String  getUplaodPag(){
        return "uploadArticle";
    }
 }
