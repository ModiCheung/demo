package com.jwt.demo.exec.common.exception;

import com.jwt.demo.exec.common.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<Result> globalExceptionHandler(BaseException e) {
        logger.error(e.getMessage(), e);
        Result responseData = Result.error(e);
        return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
    }

}
