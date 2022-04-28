package com.fc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadUtil {
    public static String fileUpload(MultipartFile file){
        //准备路径
        String path = "D:\\Java\\apache-tomcat-8.5.37\\webapps\\uploadImg";

        File location = new File(path);

        //如果路径不存在就创建一个
        if (!location.exists()){
            location.mkdirs();
        }
        String filename = file.getOriginalFilename();
        //获取后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String formatter = dateFormat.format(new Date());
        filename = formatter + suffix;

        try {
            file.transferTo(new File(location,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path+"/"+filename);
        return path+"/"+filename;
    }
}
