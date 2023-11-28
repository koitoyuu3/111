package com.example.mybatispluspractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.mybatispluspractice.mapper")
@SpringBootApplication
public class MybatisPlusPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusPracticeApplication.class, args);
    }

}
