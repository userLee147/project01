package com.kh.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
		public Member loginMember(SqlSession sqlSession, Member m) {
		
		Member loginMember = sqlSession.selectOne("MemberMapper.loginMember", m);
	
		return loginMember;
	}

		public int insertMember(SqlSession sqlSession, Member m) {
			
			
			return sqlSession.insert("MemberMapper.insertMember", m);
		}

		public int updateMember(SqlSession sqlSession, Member m) {
			
			return sqlSession.update("MemberMapper.updateMember", m);
		}

		public Member selectOneMember(SqlSession sqlSession, int mNO) {
			return sqlSession.selectOne("MemberMapper.selectOneMember",mNO);
		}
	
}
