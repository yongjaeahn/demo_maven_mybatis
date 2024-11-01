package com.example.demo_maven_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    @Select("SELECT sysdate FROM dual")
    public String getTime();

    // TimeMapper.xml을 사용하게 됨
    public String getTime2();
}
