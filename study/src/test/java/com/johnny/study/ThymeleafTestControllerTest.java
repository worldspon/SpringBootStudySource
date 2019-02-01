package com.johnny.study;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.johnny.study.controller.ThymeleafTestController;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(ThymeleafTestController.class)
public class ThymeleafTestControllerTest {

    // HTML Unit Test : HTML 사이트와 상호작용을 테스트할 수 있는 기능이다.
    @Autowired
    WebClient webClient;

    @Test
    public void hello() throws Exception {
        HtmlPage page = webClient.getPage("/thymeleafTest"); // 템플릿 파일을 읽어온다,
        HtmlSpan span = page.getFirstByXPath("//span"); // 템플릿에서 span 태그를 찾는다.
        Assertions.assertThat(span.getTextContent()).isEqualToIgnoringCase("Hello, This is Thymeleaf test page !!!"); // Model Attribute value 와 일치한지 검증한다.
    }

    @Test
    public void titlePageIsOk() throws Exception {
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        HtmlPage page = webClient.getPage("/thymeleafTest");
        Assert.assertEquals("Thymeleaf Test", page.getTitleText()); // 템플릿의 title 텍스트가 일치한지 검증한다.
    }
}
