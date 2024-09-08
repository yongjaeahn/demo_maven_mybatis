package com.example.demo_maven_mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeMapperTest {
    @Autowired
    private TimeMapper timeMapper;

    @Test
    void testGetTime() {
        System.out.print("timeMapper.getClass().getName() : ");
        System.out.println(timeMapper.getClass().getName());

        System.out.print("timeMapper.getTime() : ");
        System.out.println(timeMapper.getTime());
    }

    @Test
    void testGetTime2() {
        System.out.print("timeMapper.getTime2() : ");
        System.out.println(timeMapper.getTime2());
    }
}