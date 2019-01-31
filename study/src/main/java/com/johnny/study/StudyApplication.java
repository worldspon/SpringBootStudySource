package com.johnny.study;

import com.johnny.study.eventlistener.AppStartedSampleListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 어노테이션은 @EnableAutoConfiguration, @ComponentScan 총 두 단계로 나뉘어 스프링 부트 프로젝트의 스프링 빈을 찾아내어 등록한다.
@SpringBootApplication
// ┌@ComponentScan : @Repository, @Configuration, @Service 등 스프링 빈을 나타내는 어노테이션을 @ComponentScan이 붙은 클래스가 위치해 있는 현재 패키지를 기준으로 그 아래 패키지까지 찾아내서 스프링 빈으로 등록한다.
// └@EnableAutoConfiguration : 스프링 프레임워크에서 많이 쓰이는 스프링 빈들을 자동적으로 컨테이너에 등록하는 역할을 한다. (자동으로 컨테이너에 등록하는 대상 목록은 spring-boot-autoconfigure-2.X.X.RELEASE.jar 파일에 포함되어 있음)
// spring-boot-autoconfigure-2.X.X.RELEASE.jar : 이 파일에는 스프링 부트 프로젝트를 기본적으로 웹 프로젝트로 만들 수 있는 Servlet Web Server Factory 빈이 설정되어 있다.
// @Configuration
// @ComponentScan
public class StudyApplication {

	// 스프링 부트는 아래의 클래스에 의해 자동적으로 Tomcat/Jetty/Undertow 등 내장 웹 서버에 대한 설정을 자동적으로 처리해준다.
	// 아래의 클래스를 들어가보면 TomcatServletWebServerFactoryCustomizer 클래스를 통해 자동적으로 톰캣을 커스터마이징 한다.
	// ServletWebServerFactoryAutoConfiguration

	// 스프링에서 web.xml에 기술했던 DispatcherServlet 관련 설정도 아래의 클래스를 통해 자동으로 처리해준다.
	// DispatcherServletAutoConfiguration

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);


		/*
		// 스프링 부트를 웹 애플리케이션이 아닌 일반 애플리케이션으로 띄우는 방법
		SpringApplication application = new SpringApplication(StudyApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
		*/


		/*
		// 이벤트 리스너를 등록하여 애플리케이션을 실행한다.
		SpringApplication application = new SpringApplication(StudyApplication.class);
		application.addListeners(new AppStartedSampleListener());
		// 1. Servlet으로 설정되어 있으면 @ConfigServletWebServerApplicationConttext (Spring MVC)
		// 2. Servlet이 없고 WebFlux로 되있으면 @ConfigReactiveWebServerApplicationContext (Spring WebFlux)
		// 3. 전부 없을 경우 @ConfigApplicationContext로 3가지 타입 모두 "자동 설정"
		application.setWebApplicationType(WebApplicationType.SERVLET); // 웹 애플리케이션 타입 지정
		application.run();
		*/
	}


	/*
	// com.tutorial.HoloMan을 재정의해서 사용하기
	// 만약 @EnableAutoConfiguration을 통해 com.tutorial.HoloMan의 @Configuration을 읽어들인 경우 이 빈을 이 프로젝트에서 재정의할 수 없다.
	@Bean
	public HoloMan holo() {
		HoloMan holo = new HoloMan();
		holo.setName("npcdja");
		holo.setHowLong(10);

		return holo;
	}
	*/
}

