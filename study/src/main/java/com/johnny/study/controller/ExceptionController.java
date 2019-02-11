package com.johnny.study.controller;

import com.johnny.study.exception.SampleException;
import com.johnny.study.model.AppError;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    // Error에 대한 웹 템플릿 경로는 /resources/static/error 경로이다.
    @GetMapping("/exceptionHello")
    public String hello() {
        throw new SampleException();
    }

//    @ExceptionHandler(SampleException.class)
//    @ResponseBody
//    public AppError sampleError(SampleException e) {
//        AppError appError = new AppError();
//        appError.setMessage("error.app.key");
//        appError.setReason("For Exception Test!!!");
//
//        return appError;
//    }
}
