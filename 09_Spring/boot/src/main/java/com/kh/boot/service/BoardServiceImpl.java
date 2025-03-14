package com.kh.boot.service;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Reply;
import com.kh.boot.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public int selectBoardCount() {
        return boardMapper.selectBoardCount();
    }

    @Override
    public ArrayList<Board> selectBoardList(PageInfo pi) {
        int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getPageLimit());

        return boardMapper.selectBoardList(rowBounds);
    }

    @Override
    public Board selectBoard(int boardNo) {

        return boardMapper.selectBoard(boardNo);
    }

    @Override
    public int insertRely(Reply r) {

        return boardMapper.insertReply(r);

    }

    @Override
    public ArrayList<Reply> getReplyList(int boardNo) {
        return boardMapper.getReplyList(boardNo);
    }

    @Override
    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
    }

    @Override
    public ArrayList<Board> photoBoard() {

        return boardMapper.photoBoard();
    }
}
