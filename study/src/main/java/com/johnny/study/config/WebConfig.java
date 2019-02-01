package com.johnny.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**") // addResourceHandlers : 리소스 위치와 매칭될 URL을 등록한다.
                .addResourceLocations("classpath:/mobile/")
                .setCachePeriod(20); // setCachePeriod : 캐시가 지속하는 주기 (second 단위)
    }
}
