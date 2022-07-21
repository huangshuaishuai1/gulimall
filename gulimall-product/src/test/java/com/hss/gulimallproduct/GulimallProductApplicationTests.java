package com.hss.gulimallproduct;


import com.hss.gulimallproduct.entity.BrandEntity;
import com.hss.gulimallproduct.service.BrandService;

import com.hss.gulimallproduct.service.CategoryService;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功...");
    }

    @Test
    public void getPath() {
        Long[] catelogPath = categoryService.getCatelogPath(225L);
        for (int i = 0; i < catelogPath.length; i++) {
            System.out.println(catelogPath[i]);
        }
    }
}
