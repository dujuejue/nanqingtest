package com.example.nanqingtest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class UploadService {

    public void uploadImage(MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + File.separator + "image";

        this.uploadFile(file.getBytes(), filePath, fileName);


    }

    /*
     *把图片存储到本地
     * */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
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
