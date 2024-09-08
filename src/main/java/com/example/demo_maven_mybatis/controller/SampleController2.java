package com.example.demo_maven_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/sample/*")
@RequestMapping("/sample")             // 아래에 나열한 path만 허용
public class SampleController2 {
    @RequestMapping("/aaa")
    public void aaa() {
        System.out.println("@RequestMapping : /sample/aaa");
    }

    @RequestMapping("/bbb")
    public void bbb() {
        System.out.println("@RequestMapping : /sample/bbb");
    }
}