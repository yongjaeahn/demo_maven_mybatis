package com.example.demo_maven_mybatis.service;

import com.example.demo_maven_mybatis.domain.BoardVO;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public  boolean modify(BoardVO board);

    public boolean remove(Long bno);

    public List<BoardVO> getList();
}
