package com.threadnew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.threadnew.dao"})
public class EncycprojectApplication {

    public static void main(String[] args) {

        SpringApplication.run(EncycprojectApplication.class, args);
    }

}
