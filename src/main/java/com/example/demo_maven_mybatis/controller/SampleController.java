package com.example.demo_maven_mybatis.controller;

import com.example.demo_maven_mybatis.domain.SampleDTO;
import com.example.demo_maven_mybatis.domain.TodoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/sample/*")     // 아래와 같은 path를 모두 수용
//@RequestMapping("/sample")
public class SampleController {
    String projectDir = System.getProperty("user.dir");
    String uploadDir = projectDir + "/uploads/";

    @RequestMapping("")
    public void basic() {
        System.out.println("@RequestMapping : /sample/*");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO sampleDTO) {
        System.out.println("@GetMapping : /sample/ex01");
        System.out.println(sampleDTO);

        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println("@GetMapping : /sample/ex02");
        System.out.print("@RequestParam(\"name\") String name : ");
        System.out.println(name);
        System.out.print("@RequestParam(\"age\") int age : ");
        System.out.println(age);

        return "ex02";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todoDTO) {
        System.out.println("@GetMapping : /sample/ex03");
        System.out.println(todoDTO);

        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO sampleDTO, int page) {
        System.out.println("@GetMapping : /sample/ex04");
        System.out.println(sampleDTO);
        System.out.println(page);

        return "/sample/ex04";
    }

    @GetMapping("/ex04-2")
    public String ex04_2(SampleDTO sampleDTO, @ModelAttribute("page") int page) {
        System.out.println("@GetMapping : /sample/ex04-2");
        System.out.println(sampleDTO);
        System.out.println(page);

        return "/sample/ex04-2";
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        System.out.println("/exUpload..........");
    }

    private int uploadFile(MultipartFile file) {
        try {
            String filePath = uploadDir + file.getOriginalFilename();

            File dest = new File(filePath);

            file.transferTo(dest);

            return 0;
        } catch(IOException e) {
            e.printStackTrace();

            return -1;
        }
    }

    @PostMapping("/exUploadPost")
    public ResponseEntity<String> exUploadPost(ArrayList<MultipartFile> files) {
        int returnCode = 0;

        for (MultipartFile file : files) {
            System.out.println("---------------------------------");
            System.out.println("name : " + file.getOriginalFilename());
            System.out.println("size : " + file.getSize());

            if (file.getSize() != 0) {
                returnCode = uploadFile(file);
                if (returnCode != 0) {
                    break;
                }
            }
        }

        if(returnCode == 0)
            return new ResponseEntity<>("이미지 업로드 성공", HttpStatus.OK);
        else
            return new ResponseEntity<>("이미지 업로드 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
