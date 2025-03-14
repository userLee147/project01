package com.kh.boot.utils;

import com.kh.boot.domain.vo.Attachment;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.Paths;

@Component
public class FileUtils {

    //String  path = "C:\workspace\09_Spring\boot\src\main\webapp\resources";
    private final HttpSession session;

    public FileUtils(HttpSession session) {
        this.session = session;
    }

    private final String savePath =  Paths.get("C:", "workspace", "09_Spring").toString();

    //출처: https://congsong.tistory.com/39#10.-application.properties---업로드-파일-사이즈-설정하기 [Let's develop:티스토리]session.getServletContext().getRealPath("/resources/uploadfile");

    public List<Attachment> uploadFiles(final List<MultipartFile> multipartFiles ) {
        List<Attachment> files = new ArrayList<>();

        for(MultipartFile multipartFile : multipartFiles) {
            if(multipartFile.isEmpty()) {
                continue;
            }
            files.add(uploadFile(multipartFile));
        }
        return files;
    }


    public Attachment uploadFile(MultipartFile multipartFile) {
        if(multipartFile.isEmpty()) {
            return null;
        }
        String changeName = generateChagneFilename(multipartFile.getOriginalFilename());

        System.out.println("savePath : "+ savePath);
        try {
            multipartFile.transferTo(new File(this.savePath +changeName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Attachment.builder()
                .originName(multipartFile.getOriginalFilename())
                .changeName(changeName)
                .fileSize(multipartFile.getSize())
                .build();
    }


    public static String generateChagneFilename(String fileName){
        //fileName = 원본파일명을 가져온다.

        //확장자
        String ext = fileName.substring(fileName.lastIndexOf("."));

        String currentTime = String.valueOf(System.currentTimeMillis());

        int random =(int) (Math.random()*1000);

        String changeName = "kh_sub"+currentTime+random+ext;

        return changeName;

    }
}
