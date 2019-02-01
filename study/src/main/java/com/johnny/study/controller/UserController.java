package com.johnny.study.controller;

import com.johnny.study.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/hello")
    public String hello() {
        return "hello user";
    }

    // 만약 HTTP에 content-type이 JSON으로 들어오면 JsonConverter로 변환됨
    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        // 스프링 부트의 ViewResolver = ContentNegotiatingViewResolver
        // ContentNegotiatingViewResolver 객체를 통해 자동으로 JSON 형식으로 데이터를 반환하도록 스프링 부트에서 제공해준다. (XML 메시지 컨버터는 의존성 추가 필요)
        // 이 View Resolver는 Converter와 연관되어 있어서 content-type을 기준으로 어떤 Converter를 쓸 지 결정한다.
        return user;
    }
}
