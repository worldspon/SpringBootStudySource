package com.johnny.study;

import com.johnny.study.controller.UserController;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello user"));
    }

    // JSON 타입으로 데이터를 Controller에 전달하고 JSON 타입으로 데이터를 응답 받기
    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\" : \"user\", \"password\" : \"1234\"}";
        // MediaType.[데이터 형식] : 스프링 3부터 지원하는 속성이며 HTTP 명세에 정의된 데이터 전달 형식을 나타내는 HTTP Response의 Content-type 리스트
        // jsonPath : response-body의 json 포맷에 접근할 수 있게 지원하는 메소드
        mockMvc.perform(MockMvcRequestBuilders.post("/users/create").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8).content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username", Is.is(CoreMatchers.equalTo("user"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Is.is(CoreMatchers.equalTo("1234"))));
    }

    // JSON 타입으로 데이터를 Controller에 전달하고 XML 타입으로 데이터를 응답 받기 (XML 메시지 컨버터 의존성 추가해야함)
    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\" : \"user\", \"password\" : \"1234\"}";
        // contentType() : JSON 형태로 내용을 전달하고 (content-type)
        // accpet() : 응답을 XML 형태로 전달받겠다는 의미 (accept)
        mockMvc.perform(MockMvcRequestBuilders.post("/users/create").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_XML).content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.xpath("/User/username").string("user"))
                .andExpect(MockMvcResultMatchers.xpath("/User/password").string("1234"));
    }
}
