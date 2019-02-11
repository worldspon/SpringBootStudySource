package com.example.Hateoas;

import com.example.Hateoas.controller.SampleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class HateoasApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void hello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$._links.self").exists());
				// _link는 HATEOAS를 구현하기 위해 스프링 부트에서 생성한 JSON name이다.
				// self는 자기 참조를 뜻하는 것은 JSON을 통해서 나타낸 것이다.
				// 결과 : Body = {"prefix":"Hey, ","name":"Johnny","_links":{"self":{"href":"http://localhost/hello"}}}
	}

}

