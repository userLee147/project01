package com.kh.mybatis.board.modal.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("BoardMapper.selectListCount");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// 마이바티스에서는 페이징처리를 위해 RowBounds라는 class를 제공
		// offset : 몇개의 게시글을 건너뛰고 조회할 것인지 
		// boardLimit : 몇개의 게시글을 가지고 올지
		
		int offset = (pi.getCurrentPage()-1)*(pi.getBoardLimit());
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectList",null,rowBounds);
		return list;
		
	}

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		
		return sqlSession.selectOne("BoardMapper.selectSearchCount", map);
	}

	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		//Board x ArryaLsit 다운캐스팅 왜...?
		int offset= (pi.getCurrentPage()-1) * (pi.getBoardLimit());
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectSearchList",map,rowBounds);
		

		return list;
	}

	public Board selectOneBoard(SqlSession sqlSession, int bno) {

		return sqlSession.selectOne("BoardMapper.selectOneBoard",bno);
	}

	public int insertBoard(SqlSession sqlSession, Board b) {
		return sqlSession.insert("BoardMapper.insertBoard", b);
	}
	public int insertReply(SqlSession sqlSession, Reply r) {
	
		return sqlSession.insert("ReplyMapper.insertReply",r);
		
	}

	public int updateBoard(SqlSession sqlSession, Board b) {

		return sqlSession.update("BoardMapper.updateBoard", b);
	}



	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, HashMap<String, String> map) {
		ArrayList<Reply> list = (ArrayList)sqlSession.selectList("ReplyMapper.selectReplyList",map);

		return list;
	}


	

}
