package com.hss.guilimall.gulimallthirdparty;

//import org.junit.jupiter.api.Test;
import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

    @Resource
    OSSClient ossClient;

    @Test
    public void uploadTest() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hp-pc\\Pictures\\黄帅帅_S210231077.png");
        ossClient.putObject("gulimall-huangss","77.png",fileInputStream);
        ossClient.shutdown();
    }


}
