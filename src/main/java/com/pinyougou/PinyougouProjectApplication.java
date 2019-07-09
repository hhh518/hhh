package com.pinyougou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.pinyougou.mapper")
public class PinyougouProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinyougouProjectApplication.class, args);
    }

}
