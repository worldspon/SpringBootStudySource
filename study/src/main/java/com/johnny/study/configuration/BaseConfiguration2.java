package com.johnny.study.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test") // properties(yml) 파일에 test라는 profiles.active 식별자가 있으면 아래의 빈 등록을 수행한다. 없으면 빈 생성이 무시됨
@Configuration
public class BaseConfiguration2 {

    @Bean
    public String hello() {
        return "Profile Test Hello()";
    }
}
