package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.PageInfo;

public interface BoardService {
	int selectListCount();
	
	ArrayList<Board> selectList(PageInfo pi);

	int selectSearchCount(HashMap<String, String> map);

	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);


	Board selectOneBoard(int bno);
	
	
	int insertReply(Reply r);

	int insertBoard(Board board);

	int updateBoard(Board board);

	ArrayList<Reply> selectReplyList(HashMap<String, String> map);

	

	
	
}
