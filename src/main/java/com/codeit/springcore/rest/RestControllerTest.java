package com.codeit.springcore.rest;

import com.codeit.springcore.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
// 빈 등록을 해야 요청이 들어왔을 때 메서드를 호출할 수 있다.
// RestController 안에 있는 모든 메서드는 return 값이 JSON으로 변환되어
// 클라이언트에게 전송됩니다. -> 더이상 백엔드는 화면에 관여하지 않습니다.
@RestController // 컨트롤러 역할 빈을 등록하겠다. 얘는 REST 방식으로 응답 할거야.
@RequiredArgsConstructor // 반드시 초기화가 요구되는 매개값을 받는 생성자 -> final 초기화 생성자
public class RestControllerTest {

    // properties (yml)파일에 작성한 설정값을 클래스로 불러오는 방법
    @Value("${message}")
    private String message;

    @Value("${server.port}")
    private int port;

    private final AppProperties appProperties;

//    public RestControllerTest(AppProperties appProperties) {
//        this.appProperties = appProperties;
//    }

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", this.message);
        map.put("port", this.port);
        map.put("appProperties", this.appProperties);
        return map;
    }


    @GetMapping("/rest/list")
//    @ResponseBody -> 클라이언트로 데이터를 JSON으로 변환 후 바로 던지는 문법
    public List<String> method1() {
        List<String> list = List.of("hello", "world", "spring", "boot", "yaho");
        return list;
    }

    @GetMapping("/rest/object")
    public Person method2() {
        Person person = new Person(
                "김춘식", 30, List.of("놀기", "밥먹기", "독서"));
        return person;
    }

    // 클라이언트(리액트 등...)가 요청과 함께 JSON 데이터를 보내고 있다.
    // 1. JSON 형태로 생긴 클래스가 있다? -> 그 객체로 받으면 되고
    // 2. JSON 형태로 생긴 클래스가 없다? -> Map으로 받으면 됩니다.
    /*
    {
      "name": "김춘식",
      "age": 30,
      "hobbies": [
        "놀기",
        "밥먹기",
        "독서"
      ]
    }
     */
    @PostMapping("/rest/regist")
    // @RequestBody: 요청과 함께 넘어오는 JSON 데이터를 자바 객체로 변환해 줘!
    public String method3(@RequestBody Map<String, Object> map) {
        System.out.println("전달된 데이터: " + map);
        String name = (String) map.get("name"); // Object를 String으로 직접 형 변환.
        return "ok!";
    }



}







