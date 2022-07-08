package com.hss.gulimallproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 逻辑删除：
 *  1)配置全局的逻辑删除规则
 *  2）配置逻辑删除的Bean（可以省略）
 *  3）给Bean加上逻辑删除注解 @TableLogic
 */
@MapperScan("com.hss.gulimallproduct.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
