package com.example.nanqingtest.service;

import com.example.nanqingtest.dao.mapper.ArticleMapper;
import com.example.nanqingtest.dao.mapper.ArticlePartMapper;
import com.example.nanqingtest.dao.mapper.ImageMapper;
import com.example.nanqingtest.model.domain.ArticleContent;
import com.example.nanqingtest.model.entity.Article;
import com.example.nanqingtest.model.entity.ArticlePart;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticlePartMapper articlePartMapper;
    @Autowired
    private ImageMapper imageMapper;
    /*
    * 下载图片
    * */
    public void getImage(String fileName,HttpServletResponse response){
        // 文件下载的路径
        String filePath =System.getProperty("user.dir") + File.separator + "image";
        File file = new File(filePath, fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024*100];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("success");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public ArticleContent getContetnt(Integer id){
        ArticleContent articleContent=new ArticleContent();
        Article article =articleMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(article,articleContent);
        List<String> contentList=articlePartMapper.selectByArticleId(id);
        List<String> imageUrlList=imageMapper.selectByByArticleId(id);
        for (int i=0;i<imageUrlList.size();i++){
            String newStr="116.62.242.1:8080/article/get/image/"+imageUrlList.get(i);
            imageUrlList.set(i,newStr);
        }
        articleContent.setContent(contentList);
        articleContent.setImageUrl(imageUrlList);
        return articleContent;
    }
}
