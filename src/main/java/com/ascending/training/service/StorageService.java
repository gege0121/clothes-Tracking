//package com.ascending.training.service;
//
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.dynamodbv2.xspec.S;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import org.apache.commons.io.FilenameUtils;
//import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//
//@Service
//public class StorageService {
//    private String bucket="closet-training";
//    @Autowired
//    private AmazonS3 s3client;
//    @Autowired
//    Private FileService fileservcie;
//
//    public String putObject(File f){
//        s3client.putObject(bucket,f.getName(),f);
//        return s3client.getUrl(bucket,f.getName()).toString();
//    }
//
//    public String getObjectURL(String key) {
//        return s3client.generatePresignedUrl(new GeneratePresignedUrlRequest(bucket,key)).toString();
//    }
//
//    public ResponseEntity putObject(MultipartFile file){
//        //MultipartFile file is the selected file from Front-end, when the file is being transferred, the file is tear down as multipart,
//        // when the transfer is ready, the server will create a File with /homedir/filename.extension in the server side, and the put it onto the s3
//        String msg = String.format("The file name = %s,size = %d is uploaded.", file.getOriginalFilename(), file.getSize());
//        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//        String homeDir = System.getProperty("catalina.base") !=null ? System.getProperty("catalina.base"):"/tmp/";
//        String s3Key = FilenameUtils.getBaseName(file.getOriginalFilename()+"_"+ UUID.randomUUID()+"."+extension);
//
//
//        File f = new File(homeDir+s3Key);
//        try {
//            file.transferTo(f);
//            msg = msg.concat(" URL = "+ FileService.putObject(f));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpServletResponse.SC_OK).body(msg);
//    }
//
//}
