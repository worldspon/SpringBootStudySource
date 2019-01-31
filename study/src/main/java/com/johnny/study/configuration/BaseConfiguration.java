package com.johnny.study.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// properties 에 작성한 profile 식별자를 통해 검증한다.
@Profile("prod") // 값이 일치할 시 클래스 내에서 명시한 스프링 빈을 등록한다.
@Configuration
public class BaseConfiguration {

    @Bean
    public String hello() {
        return "Profile Prod Hello()";
    }
}
