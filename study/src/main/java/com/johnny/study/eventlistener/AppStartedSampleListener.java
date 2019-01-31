package com.johnny.study.eventlistener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component // 스프링 컨테이너가 만들어진 이후에 생성되는 이벤트들은 스프링 빈 등록(@Component, @Bean)을 통해 이벤트를 처리할 수 있다.
public class AppStartedSampleListener implements ApplicationListener<ApplicationStartingEvent> {

    // 이벤트 리스너
    // 스프링 부트 실행 시 구동되는 단계마다 이벤트들이 발생한다.
    // 여기서 사용자가 원하는 이벤트 단계를 캐치해서 작업을 할 수 있다.

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("====================");
        System.out.println("Application starting!!!!");
        System.out.println("====================");
    }
}
