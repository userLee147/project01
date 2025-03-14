package com.kh.boot.service;

import com.kh.boot.domain.vo.Member;

public interface MemberService {

   //로그인
    Member loginMember(String userId);
   // 회원가입
    int insertMember(Member member);
    //id 중복조회
    int idCheck(String userId);
}
