package com.kh.boot.mappers;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    int selectBoardCount();

    ArrayList<Board> selectBoardList(RowBounds rowBounds);

    Board selectBoard(int boardNo);

    int insertReply(Reply r);

    ArrayList<Reply> getReplyList(int boardNo);

    int insertBoard(Board board);

    ArrayList<Board> photoBoard();
}
