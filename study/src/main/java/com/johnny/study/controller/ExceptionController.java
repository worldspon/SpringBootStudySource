package com.johnny.study.controller;

import com.johnny.study.exception.SampleException;
import com.johnny.study.model.AppError;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/exceptionHello")
    public String hello() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    @ResponseBody
    public AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("For Exception Test!!!");

        return appError;
    }
}
