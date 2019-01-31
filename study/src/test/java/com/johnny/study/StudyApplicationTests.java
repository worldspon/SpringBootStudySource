package com.johnny.study;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// application.properties를 test > resources 경로에 넣어놓으면 그것을 읽어들이는 것이 1순위가 된다.
// 그러나 main에 있는 properties가 무시되기 때문에 가급적 test 어노테이션을 사용하여 설정해주자.
@TestPropertySource(properties = "holo.name=johnny_test") // 2순위
@SpringBootTest
//@SpringBootTest(properties = "holo.name=test") // 3순위
public class StudyApplicationTests {

	@Autowired
	Environment env;

	@Test
	public void contextLoads() {
		Assertions.assertThat(env.getProperty("holo.name"))
				.isEqualTo("johnny_test");
	}

}

