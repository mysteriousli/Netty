package com.example.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class NettyApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext con  = new AnnotationConfigApplicationContext();
//        con.getBean();
        SpringApplication.run(NettyApplication.class, args);
    }

}
