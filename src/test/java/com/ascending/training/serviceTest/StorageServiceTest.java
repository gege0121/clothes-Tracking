package com.ascending.training.serviceTest;


//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.ascending.training.ApplicationBoot;
//import com.ascending.training.service.StorageService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import static org.mockito.Mockito.*;
//import org.mockito.stubbing.OngoingStubbing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.util.IOUtils;
import com.ascending.training.ApplicationBoot;
import com.ascending.training.service.StorageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.io.File;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class StorageServiceTest {
    @Mock
    @Autowired private AmazonS3 amazonS3;

    @InjectMocks
    @Autowired
    private StorageService storageService;




    @Test
    public void putObjectTest(){
//        File f= new File("/Users/gege/Downloads/tickets-59BBB6AC97B538F18DF6.pdf");
        File f = mock(File.class);
        when(f.getName()).thenReturn("abc");
        storageService.putObject(f);
        verify(amazonS3,times(1)).putObject("closet-training", f.getName(), f);

    }

//    @Test
//    public void putObjectTest1(){
//        MultipartFile mf=mock(MultipartFile.class);
//        when(mf.getOriginalFilename()).thenReturn("zhibo.jpg");
//        when(amazonS3.putObject(anyString(),anyString(),any(File.class))).thenReturn(mock(PutObjectRequest.class));
//        storageService.uploadObject(mf);
//    }

}
