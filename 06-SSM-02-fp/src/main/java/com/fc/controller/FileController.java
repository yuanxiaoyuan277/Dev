package com.fc.controller;

import com.fc.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
public class FileController {
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("uploadImg")
    public String upload(MultipartFile upload,String type) {
        return fileUploadService.getURL(upload,type);
    }
}
