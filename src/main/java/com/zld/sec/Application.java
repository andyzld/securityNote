package com.zld.sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2018/1/11.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Throwable {
        System.out.println(123);
        SpringApplication.run(Application.class, args);
    }

}
