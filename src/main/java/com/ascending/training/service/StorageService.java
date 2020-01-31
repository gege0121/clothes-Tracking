//package com.ascending.training.service;
//
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.dynamodbv2.xspec.S;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//
//@Service
//public class StorageService {
//    private String bucket="closet-training";
//    private AmazonS3 s3client;
//    public void putObject(File f){
//        s3client.putObject(bucket,f.getName(),f);
//    }
//    public void getOject(String key){
//
//    }
//
//}
