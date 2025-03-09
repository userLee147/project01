package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.Template;
import com.kh.mybatis.member.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDao mDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {

			SqlSession sqlSession = Template.getSqlSession();
			Member loginMember = mDao.loginMember(sqlSession, m);
			
			sqlSession.close();
			
			return loginMember;

		}

	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.insertMember(sqlSession,m);
		
		if(result >0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int updateMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.updateMember(sqlSession, m);
		
		Member updateMember = null;
		if(result > 0) {
			sqlSession.commit();
			
		}else {
			sqlSession.rollback();
		}
		return result;
	}

	@Override
	public Member selectOneMember(int mNO) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member m = mDao.selectOneMember(sqlSession, mNO);
		
		sqlSession.close();
		return m;
	}

}
	

	



