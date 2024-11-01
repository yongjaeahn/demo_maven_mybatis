package com.example.demo_maven_mybatis.mapper;

import com.example.demo_maven_mybatis.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    void testGetList() {
        boardMapper.getList().forEach(board -> log.info(String.valueOf(board)));
    }

    @Test
    void testInsert() {
        BoardVO boardVO = new BoardVO();

        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");

        int insertedCount = boardMapper.insert(boardVO);

        log.info("추가 건수 : " + insertedCount);
        log.info(String.valueOf(boardVO));
    }

    @Test
    void testInsertSelectKey() {
        BoardVO boardVO = new BoardVO();

        boardVO.setTitle("새로 작성하는 글 Select Key");
        boardVO.setContent("새로 작성하는 내용 Select Key");
        boardVO.setWriter("newbie Select Key");

        int insertedCount = boardMapper.insertSelectKey(boardVO);

        log.info("추가 건수 : " + insertedCount);
        log.info(String.valueOf(boardVO));
    }

    @Test
    void testRead() {
        BoardVO boardVO = boardMapper.read(9L);

        log.info(String.valueOf(boardVO));
    }

    @Test
    void testDelete() {
        int deletedCount = boardMapper.delete(8L);

        log.info("삭제 건수 : " + deletedCount);
    }

    @Test
    void testUpdate() {
        BoardVO boardVO = new BoardVO();

        boardVO.setBno(10L);
        boardVO.setTitle("수정된 제목");
        boardVO.setContent("수정된 내용");
        boardVO.setWriter("user00");

        int updatedCount = boardMapper.update(boardVO);

        log.info("수정 건수 : " + updatedCount);
    }
}