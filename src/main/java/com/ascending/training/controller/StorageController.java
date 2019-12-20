package com.ascending.training.controller;

import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.ascending.training.service.MessageService;
import com.ascending.training.service.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping(value = {"/files"})
public class StorageController {
    @Autowired private Logger logger;
    @Autowired private StorageService storageService;
    @Autowired private MessageService messageService;
    @Value("${file.download.dir}")
    private String fileDownloadDir;
    @Value("${aws.sqs.name}")
    private String queueName;

    // /files POST

    @RequestMapping(value ="", method= RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file){
        String msg=String.format("The file name=%s, size=%d has been uploaded", file.getOriginalFilename(), file.getSize());
        String extension= FilenameUtils.getExtension(file.getOriginalFilename());
        String homeDir=System.getProperty("catalina.base")!=null? System.getProperty("catalina.base"):"/temp/";
        String s3key=FilenameUtils.getBaseName(file.getOriginalFilename())+"_"+ UUID.randomUUID()+"."+extension;

        File f = new File(homeDir+s3key);
        try {
            UUID.randomUUID();
            file.transferTo(f);
            storageService.putObject(f);

        }catch(IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(msg);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> downloadFile(@PathVariable String key, HttpServletRequest request) {
        Resource resource = null;
        String msg = "The file doesn't exist.";
        ResponseEntity responseEntity;

        try {
            Path filePath = Paths.get(fileDownloadDir).toAbsolutePath().resolve(key).normalize();
            resource = new UrlResource(filePath.toUri());
            if(!resource.exists()) return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(msg);
            responseEntity = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);;

            msg = String.format("The file %s was downloaded", resource.getFilename());
            //Send message to SQS
            messageService.sendMessage(queueName, msg);
            logger.debug(msg);
        }
        catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(ex.getMessage());
            logger.debug(ex.getMessage());
        }

        return responseEntity;
    }




}
