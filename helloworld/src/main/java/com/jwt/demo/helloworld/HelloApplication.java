package com.jwt.demo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloApplication {

    @Value("${a.b}")
    private String b;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
        System.out.println("hello项目启动成功");
    }

    @Bean
    public String string() {
        System.out.println(b);
        return "b";
    }
}
