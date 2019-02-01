package com.johnny.study.controller;

import com.johnny.study.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + sampleService.getName();
    }

    // OutputCapture 테스트를 위한 통신 메소드
    @GetMapping("/logging")
    public String logging() {
        log.info("logging output test");
        System.out.println("System out test");
        return "hello " + sampleService.getName();
    }
}
