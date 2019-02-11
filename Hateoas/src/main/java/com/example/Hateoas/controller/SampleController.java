package com.example.Hateoas.controller;

import com.example.Hateoas.model.Hello;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    // HATEOAS : Hypermedia As The Engine Of Application State의 약자로, 하이퍼 미디어를 REST API의 상태 정보를 관리하기 위한 매커니즘으로 활용하는 것이다.
    // REST API에서 클라이언트에 리소스를 전달해줄 때 부가적인 리소스의 링크 정보를 넘겨주게 되며, 이를 통해 REST API의 리소스 상태에 따른 관리를 한다.

    // HATEOAS를 쓰는 이유는 REST API의 단점을 보완하기 위해서 사용한다.
    // 1. REST API는 엔드포인트 URL이 정해지고 나면 이를 변경하기 어렵다는 단점이 있다.
    // 2. 정적 자원의 상태에 따른 요소를 서버에서 구현하기 어렵기 때문에 클라이언트에서 비즈니스 로직을 작성해야한다.

    // 위의 단점들을 links 요소를 통해 href 값의 형태로 보내주기 때문에 자원 상태에 대한 처리를 링크에 있는 URL을 통해 처리할 수 있게 된다.

    @GetMapping("/hello")
    public Resource<Hello> hello() {
        Hello  hello = new Hello();
        hello.setPrefix("Hey, ");
        hello.setName("Johnny");

        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(
                ControllerLinkBuilder.linkTo(
                        ControllerLinkBuilder.methodOn(SampleController.class)
                                .hello()
                ).withSelfRel());

        return helloResource;
    }
}
