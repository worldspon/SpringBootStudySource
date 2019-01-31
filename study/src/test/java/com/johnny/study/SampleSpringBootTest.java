package com.johnny.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @RunWith : JUnit 프레임워크가 테스트를 실행할 때 테스트 실행방법을 확장하기 위해 사용한다.
@RunWith(SpringRunner.class)
// @SpringBootTest : @SpringBootApplication을 기준으로 스프링 빈을 등록함과 동시에 Maven 빌드 툴에 의해 추가된 org-springframework-boot 의존성도 제공해준다.
// WebEnviroment 값을 통해 테스트 시 Mockking할 것인지 Servlet컨테이너를 띄울 것인지 결정한다.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
// @AutoConfigureMockMvc : Mock 테스트 시 필요한 의존성을 제공해준다.
@AutoConfigureMockMvc
public class SampleSpringBootTest {

    @Autowired
    MockMvc mockMvc; // MockMvc 객체를 통해 실제 컨테이너가 실행되는 것은 아니지만 로직상 테스트를 진행할 수 있게 해준다. (DispatcherServlet은 로딩이 된다.)

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello")) // Controller에서 getMapping = "/hello"가 있는가?
                .andExpect(status().isOk()) // 통신 상태가 200이 리턴된다면
                .andExpect(content().string("hello Holoman")) // 컨텐츠(Response body)에 "hello Holoman"이 있는가?
                .andDo(print()); // 결과 출력
    }
}
