package com.ascending.training.serviceTest;


import com.ascending.training.ApplicationBoot;
import com.ascending.training.service.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class StorageServiceTest {
    @Autowired
    private StorageService storageService;
    @Test
    public void putObjectTest(){
        File f= new File("/Users/gege/Downloads/algorithm.pdf");
        storageService.putObject(f);
    }
}
