package com.example.demo_maven_mybatis.mapper;

import com.example.demo_maven_mybatis.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    //@Select("select * from tbl_board")   // 이 문장을 주석처리하면 xml 파일을 사용하게 됨
    public List<BoardVO> getList();

    public int insert(BoardVO boardVO);          // 특별한 설정이 없어도 추가 건수가 반환됨

    public int insertSelectKey(BoardVO boardVO); // 특별한 설정이 없어도 추가 건수가 반환됨

    public BoardVO read(Long bno);

    public int delete(Long bno);         // 특별한 설정이 없어도 삭제 건수가 반환됨

    public int update(BoardVO boardVO);  // 특별한 설정이 없어도 수정 건수가 반환됨
}
