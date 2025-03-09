package com.kh.mybatis.member.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	Member loginMember(Member m);
	
	int insertMember(Member m);
	
	int updateMember(Member m);

	Member selectOneMember(int mNO);
}
