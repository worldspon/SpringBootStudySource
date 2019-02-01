package com.johnny.study.controller;

import com.johnny.study.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController : 스프링 프레임워크 4부터 추가 되었으며, 뷰 정보가 아닌 데이터를 서비스한다.
//                  @Controller와 달리 모든 통신 메소드들에 @ResponseBody를 적용시켜준다.
//                  @ResponseBody를 생략해도 HttpMessageConverter 인터페이스를 통해 자동적으로 반환 객체를 HTTP 응답 본문으로 변환해준다.
@RestController
public class SampleController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        // 리턴 타입이 String이므로 StringMessageConverter 구현체가 사용되어 String 객체를 HTTP 응답 본문으로 변환해준다.
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
