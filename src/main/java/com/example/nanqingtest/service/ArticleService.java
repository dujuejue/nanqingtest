package com.example.nanqingtest.service;

import com.example.nanqingtest.dao.mapper.ArticleMapper;
import com.example.nanqingtest.model.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
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

    public Article getContetnt(Integer id){
        Article article =articleMapper.selectByPrimaryKey(id);
        return article;
    }
}
