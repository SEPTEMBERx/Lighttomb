package com.communitylight.Controller;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 10:28
 */


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.communitylight.Mapper"})
@ComponentScan(basePackages = {"com.communitylight"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}