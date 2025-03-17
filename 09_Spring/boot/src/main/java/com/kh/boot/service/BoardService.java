package com.kh.boot.service;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Photoboard;
import com.kh.boot.domain.vo.Reply;

import java.util.ArrayList;

public interface BoardService {
    int selectBoardCount();

    ArrayList<Board> selectBoardList(PageInfo pi);

    Board selectBoard(int boardNo);

    int insertRely(Reply r);

    ArrayList<Reply> getReplyList(int boardNo);

    int insertBoard(Board board);




}
