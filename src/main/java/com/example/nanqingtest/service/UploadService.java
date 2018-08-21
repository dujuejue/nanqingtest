package com.example.nanqingtest.service;

import com.example.nanqingtest.dao.mapper.ArticleMapper;
import com.example.nanqingtest.dao.mapper.ArticlePartMapper;
import com.example.nanqingtest.dao.mapper.ImageMapper;
import com.example.nanqingtest.model.entity.Article;
import com.example.nanqingtest.model.entity.ArticlePart;
import com.example.nanqingtest.model.entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UploadService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ArticlePartMapper articlePartMapper;


    private List<String> imageUrl = new ArrayList<>();

    private List<String> contextList = new ArrayList<>();


    public void saveArticle(String author) {

        Article article = new Article();
        article.setAuthor(author);
        article.setCreateTime(new Date());
        articleMapper.insert(article);
        int sort = 0;
        for (String url : imageUrl) {

            Image image = new Image();
            image.setUrl(url);
            image.setArticleId(article.getId());
            image.setSort(sort);
            imageMapper.insert(image);
            sort++;
        }
        sort = 0;
        for (String text : contextList) {

            ArticlePart articlePart = new ArticlePart();
            articlePart.setContext(text);
            articlePart.setArticleId(article.getId());
            articlePart.setSort(sort);
            articlePartMapper.insert(articlePart);
            sort++;
        }
        imageUrl.clear();
        contextList.clear();
    }


    /*
     * 添加文字内容
     * */
    public void uploadText(String context) {
        contextList.add(context);
    }


    /*
     * 存储图片到本地
     * */
    public void uploadImage(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "image";

        this.uploadFile(file.getBytes(), filePath, fileName);
        imageUrl.add(fileName);
    }


    /*
     *把文件存储到本地
     * */
    private static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + File.separator + fileName);
        out.write(file);
        out.flush();
        out.close();
    }


}
