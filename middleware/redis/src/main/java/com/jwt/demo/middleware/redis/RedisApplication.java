package com.jwt.demo.middleware.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);

        try {
            FileWriter fw = new FileWriter("aa.txt");
            fw.write("aaa\n");
            fw.write("bbb\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
