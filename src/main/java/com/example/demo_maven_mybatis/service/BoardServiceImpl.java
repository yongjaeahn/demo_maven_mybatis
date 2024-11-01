package com.example.demo_maven_mybatis.service;

import com.example.demo_maven_mybatis.domain.BoardVO;
import com.example.demo_maven_mybatis.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void register(BoardVO board) {
        log.info("Before register..." + String.valueOf(board));

        boardMapper.insertSelectKey(board);

        log.info("After register..." + String.valueOf(board));
    }

    public BoardVO get(Long bno) {
        log.info("get..." + bno);

        return boardMapper.read(bno);
    }

    public  boolean modify(BoardVO board) {
        log.info("modify...");

        return boardMapper.update(board) == 1;
    }

    public boolean remove(Long bno) {
        log.info("delete...");

        return boardMapper.delete(bno) == 1;
    }

    public List<BoardVO> getList() {
        log.info("getlist...");

        return boardMapper.getList();
    }
}
