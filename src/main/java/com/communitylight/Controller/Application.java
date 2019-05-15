package com.communitylight.Controller;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 10:28
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.communitylight"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}