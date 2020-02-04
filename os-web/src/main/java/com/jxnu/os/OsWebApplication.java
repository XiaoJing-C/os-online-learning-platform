package com.jxnu.os;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.jxnu.os.mapper")
@SpringBootApplication
public class OsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsWebApplication.class, args);
    }

}
