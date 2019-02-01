package com.johnny.study;

import com.johnny.study.controller.SampleController;
import com.johnny.study.service.SampleService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/*
 * @RunWith : JUnit 프레임워크가 테스트를 실행할 때 테스트 실행방법을 확장하기 위해 사용한다.
 * @SpringBootTest : @SpringBootApplication을 기준으로 스프링 빈을 등록함과 동시에 Maven 빌드 툴에 의해 추가된 org-springframework-boot 의존성도 제공해준다.
 *                  WebEnviroment 값을 통해 테스트 시 Mockking할 것인지 Servlet컨테이너를 띄울 것인지 결정한다. (MockUp 테스트 시 MOCK, Servlet 테스트 시 RANDOM_PORT 옵션 사용)
 * @AutoConfigureMockMvc : Mock 테스트 시 필요한 의존성을 제공해준다.
*/
@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // -- Servlet Container를 통해 수많은 스프링 빈을 모두 등록하고, 프로젝트 내 모든 단위의 테스트 시 활성화
// @AutoConfigureMockMvc // -- MockUpTest 시 활성화
@WebMvcTest(SampleController.class) // -- 웹 테스트에서 필요한 @Controller, @ControllerAdvice, @JsonComponenet, @Convert 등의 어노테이션이 붙은 빈들만 등록한다.
public class SampleSpringBootTest {

    /*
    // MockUp Test : 스프링 부트 컨테이너를 사용하지 않고 컨테이너를 Mockking하여 가상의 컨테이너를 생성하고 클래스들을 로드한다.
    @Autowired
    MockMvc mockMvc; // MockMvc 객체를 통해 실제 스프링 부트 컨테이너가 실행되는 것은 아니지만 로직상 테스트를 진행할 수 있게 해준다. (DispatcherServlet은 로딩이 된다.)

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello")) // Controller에서 getMapping = "/hello"가 있는가?
                .andExpect(status().isOk()) // 통신 상태가 200이 리턴된다면
                .andExpect(content().string("hello Holoman")) // 컨텐츠(Response body)에 "hello Holoman"이 있는가?
                .andDo(print()); // 결과 출력
    }
    */


    /*
    // Servlet Container Test : 웹 애플리케이션에 연관된 모든 클래스들을 로드한다.
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void hello() throws Exception {

        String result = testRestTemplate.getForObject("/hello", String.class);
        Assertions.assertThat(result).isEqualTo("hello Holoman");
    }
    */


    /*
    // Servlet Container Test with MockBean : 스프링 부트 컨테이너가 필요하고 빈이 컨테이너에 존재해야 한다면 MockBean을 사용한다. (Spring Framework의 Mockito 패키지)
    @Autowired
    TestRestTemplate testRestTemplate;

    // @MockBean : 동일한 타입의 빈이 존재하는 경우 MockBean 객체로 가져오고 인터페이스를 구현하는 것 처럼 내부 비즈니스 로직은 직접 구현한다.
    @MockBean
    SampleService sampleService;

    @Test
    public void hello() throws Exception {
        // Mockito when() & thenReturn() : Mockito 객체의 when() 메소드와 thenReturn() 메소드를 통해 컨트롤러가 수행하는 작업을 흉내낼 수 있다.
        Mockito.when(sampleService.getName()).thenReturn("holo"); // when()으로 sampleService 객체의 getName() 서비스를 호출했으며, 그에 따른 뷰 페이지의 리턴을 'holo'라는 문자열을 리턴해주는 의미를 담은 코드

        String result = testRestTemplate.getForObject("/hello", String.class);
        Assertions.assertThat(result).isEqualTo("hello Holoman");
    }
    */



    /*
    // Servlet Container Test with WebTestClient for Asynchronous : 웹 클라이언트를 통해서 비동기 형식으로 테스트를 할 수 있다. (webflux 의존성 필요)
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    SampleService sampleService;

    @Test
    public void hello() throws Exception {
        Mockito.when(sampleService.getName()).thenReturn("holo");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk() // 서버 응답이 200인 경우
                .expectBody(String.class).isEqualTo("hello holo");
    }
    */


    /*
    // Slice Unit Test : 필요한 빈만 등록하여 테스트를 할 수 있다. (슬라이스 테스트)
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SampleService sampleService;

    @Test
    public void hello() throws Exception {
        Mockito.when(sampleService.getName()).thenReturn("holo");

        mockMvc.perform(get("/hello"))
                .andExpect(MockMvcResultMatchers.content().string("hello holo"));
    }
    */


    // OutputCapture Test : 콘솔에 출력되는 로깅 메시지를 테스트할 수 있다.
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SampleService sampleService;

    @Test
    public void logging() throws Exception {
        Mockito.when(sampleService.getName()).thenReturn("logging");

        mockMvc.perform(get("/logging"))
                .andExpect(MockMvcResultMatchers.content().string("hello logging"));

        Assertions.assertThat(outputCapture.toString())
                .contains("logging output test")
                .contains("System out test");
    }
}
