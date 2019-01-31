package com.johnny.study.runner;

import com.johnny.study.properties.HolomanProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// ApplicationRunner 구현해보기 - Web Application이 아닌 Javax Application으로 실행하기 위해 ApplicationRunner를 상속함
@Component
public class AppRunner implements ApplicationRunner {

    /*
    @Autowired
    HoloMan holo;
    */

    /*
    // com.tutorial.testautoconfigure 라이브러리에서 정의한 @Configuration 설정된 객체를 호출하기
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holo.getName());
        System.out.println(holo.getHowLong());
    }
    */

    /*
    // StudyApplication에 등록한 이 프로젝트의 스프링 빈을 사용한다.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holo.getName());
        System.out.println(holo.getHowLong());
    }
    */

    /*
    // 스프링 빈이 아닌 property(yml)로 오버라이딩한 값 호출하기
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("holo.getName : " + holo.getName());
        System.out.println("holo.getHowLong : " + holo.getHowLong());
    }
    */

    /*
    // 스프링 부트 커맨드 인자 처리
    // 스프링 부트는 아래의 코드를 실행할 때 -Dfoo VM 옵션은 무시한 채 --bar 애플리케이션 인자를 처리하게 된다.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo : " + args.containsOption("foo")); // VM 옵션은 arguments가 아니다.
        System.out.println("bar : " + args.containsOption("bar"));
    }
    */



    /*
    // application.yml에 정의한 속성 값들을 @Value 스프링 어노테이션으로 바인딩함
    @Value("${holo.name}")
    private String name;
    @Value("${holo.how-long}")
    private int howLong;
    @Value("${holo.full-name}")
    private String fullName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============ AppRunner ============");
        System.out.println("name : " + name);
        System.out.println("howLong : " + howLong);
        System.out.println("fullName : " + fullName);
        System.out.println("================================");
    }
    */







    /*
    // properties 패키지의 HoloManProperties를 불러와서 프로퍼티의 값을 받아온다. @ConfigurationProperties 어노테이션의 역할
    @Autowired
    HolomanProperties holoProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============ AppRunner ============");
        System.out.println("name : " + holoProperties.getName());
        System.out.println("howLong : " + holoProperties.getHowLong());
        System.out.println("fullName : " + holoProperties.getFullName());
        System.out.println("================================");
    }
    */




    /*
    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============ AppRunner ============");
        System.out.println(hello);
        System.out.println("================================");
    }
    */



    // slf4j 로깅 파서드(로깅 모듈을 추상화한 것)를 통해 logback 로깅 모듈 지원
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("============ AppRunner ============");
        log.info("This is wrote for logback!!!!!!!!!");
        log.info("================================");
    }
}
