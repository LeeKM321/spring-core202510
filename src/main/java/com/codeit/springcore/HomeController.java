package com.codeit.springcore;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러 역할 빈을 등록하겠다. Component랑 똑같은데, 이름으로 역할을 구분할라고.
public class HomeController {

    public HomeController() {
        System.out.println("HomeController 생성됨! 내가 생성한 거 아님!");
    }

    @GetMapping("/hello")
    @ResponseBody
    public String home(String name) {
        System.out.println("서버에 요청이 들어옴!");
        return "home";
    }

}











