package com.johnny.study.server;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    // 내장 웹 서버가 실제 application.yml에서 설정한 포트 대로 돌아가는지 리스너 이벤트를 받아 출력해보기
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        ServletWebServerApplicationContext appContext = event.getApplicationContext();
        System.out.println("Embedded Web Server Port Information : " + appContext.getWebServer().getPort());
    }
}
