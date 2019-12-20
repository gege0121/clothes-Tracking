package com.ascending.training.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.xspec.S;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Service
public class StorageService {
    @Autowired private AmazonS3 s3Client;
    @Autowired private Logger logger;
    private String bucket="closet-training";


    public void putObject( File f){
        if(f!=null){s3Client.putObject(bucket, f.getName(), f);
        }
}
    public void getObject(String key){
        if(key!=null){
        s3Client.getObject(bucket, key);}
}

    public void uploadObject(MultipartFile mf){
        String originalFileName=mf.getOriginalFilename();
        File f =new File(originalFileName);
        try {
            mf.transferTo(f);
        }catch(IOException e){
            e.printStackTrace();
        }
        if(f!=null){
            PutObjectResult por=s3Client.putObject(bucket, f.getName(), f);
            logger.info(por.getContentMd5());
        }
    }


}
