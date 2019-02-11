package com.example.CORS;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    // 18080 port의 서버에서 오는 요청을 허용한다. (스크립트를 통해 자원을 획득할 수 있도록 허용)
    // @CrossOrigin(origins = "http://localhost:18080")
    @GetMapping("/hello")
    public String hello() {
        return "hello from 8080 port.";
    }
}
