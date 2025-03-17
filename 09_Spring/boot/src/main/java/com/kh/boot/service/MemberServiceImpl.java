package com.kh.boot.service;

import com.kh.boot.domain.vo.Member;
import com.kh.boot.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // 직접객체를 생성하는것이 아니라 생성자를 통해 매퍼를 연결해서 스프링이 찾게금..?
@Service //@componet보더 더 구체화해서 service 객체에 알맞게 bean에 등록이 됨
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public Member loginMember(String userId) {

        return memberMapper.loginMember(userId);
    }

    @Override
    public int insertMember(Member member) {

        return memberMapper.insertMember(member);
    }

    @Override
    public int idCheck(String userId) {

        return memberMapper.idCheck(userId);
    }

}
