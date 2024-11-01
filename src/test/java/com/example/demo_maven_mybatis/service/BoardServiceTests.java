package com.example.demo_maven_mybatis.service;

import com.example.demo_maven_mybatis.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    void testExist() {
        log.info("testExist 메소드를 실행합니다.");
        log.info(String.valueOf(boardService));
        assertNotNull(boardService);
    }

    @Test
    void testRegister() {
        BoardVO boardVO = new BoardVO();

        boardVO.setTitle("서비스로 새로 작성하는 글");
        boardVO.setContent("서비스로 새로 작성하는 내용");
        boardVO.setWriter("yongjaeahn");;

        boardService.register(boardVO);

        log.info("생성된 게시물의 번호 : " + boardVO.getBno());
    }

    @Test
    void testGetList() {
        log.info("게시물 목록(getList)");
        boardService.getList().forEach(boardVO -> log.info(String.valueOf(boardVO)));
    }

    @Test
    void testGet() {
        log.info("1번 게시물");
        log.info(boardService.get(1L).toString());
    }

    @Test
    void testUpdate() {
        BoardVO boardVO = boardService.get(1L);
        //log.info("수정전 : " + boardService.get(1L).toString());

        if (boardVO == null) return;

        boardVO.setTitle("제목을 수정합니다. 2222");
        log.info("Modify Result : " + boardService.modify(boardVO));
        log.info("수정후 : " + boardService.get(1L).toString());
    }

    @Test
    void testDelete() {
        log.info("Remove Result : " + boardService.remove(1L));
    }
}

