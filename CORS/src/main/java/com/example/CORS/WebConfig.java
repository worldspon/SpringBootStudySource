package com.example.CORS;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:18080");
        // @CrossOrigin 어노테이션을 통해서도 허용해줄 수 있지만
        // WebMvcConfigurer를 상속받은 웹 설정 클래스에서도 CORS 허용을 해줄 수 있다.
        // 이 경우 Controller에서 @CrossOrigin 어노테이션을 사용하지 않음.
    }
}
