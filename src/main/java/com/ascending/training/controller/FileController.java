package com.ascending.training.controller;

import com.ascending.training.service.StorageService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class FileController {
    @Autowired private Logger logger;
    @Autowired private StorageService storageService;
    // /files POST

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file){
        String msg=String.format("The file name=%s, size=%d could not be uploaded", file.getOriginalFilename(), file.getSize());
        return
    }
}
