package com.jwt.demo.thread_examples.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

@RestController
public class TestController {

    @RequestMapping("/test")
    public void test(HttpServletRequest request) throws IOException, ServletException {
        Part aaa = request.getPart("aaa");
        aaa.write("classpath*: /a.json");
        System.out.println("test");
    }
}
