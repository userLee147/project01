package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.modal.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.PageInfo;
import com.kh.mybatis.common.Template;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();		
		int result = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		return list;
	}
	
	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();		
		int result = bDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	public Board selectOneBoard(int bno) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Board b = bDao.selectOneBoard(sqlSession, bno);
		
		sqlSession.close();
		return b;
	}

}
