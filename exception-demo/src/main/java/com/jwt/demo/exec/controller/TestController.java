package com.jwt.demo.exec.controller;

import com.jwt.demo.exec.common.enumeration.BusinessErrorCode;
import com.jwt.demo.exec.common.exception.BaseException;
import com.jwt.demo.exec.common.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/aaa")
    public Result aaa() {
//        return new ResponseData("", "", "111");
        throw new BaseException(BusinessErrorCode.UNKNOWN_ERROR);
    }
}
