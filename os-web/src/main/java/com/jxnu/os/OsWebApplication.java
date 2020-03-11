package com.jxnu.os;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(basePackages = "com.jxnu.os.mapper")
@EnableCaching
@SpringBootApplication
public class OsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsWebApplication.class, args);
    }

}
