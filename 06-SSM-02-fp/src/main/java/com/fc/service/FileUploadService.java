package com.fc.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String getURL(MultipartFile upload,String type);
}
