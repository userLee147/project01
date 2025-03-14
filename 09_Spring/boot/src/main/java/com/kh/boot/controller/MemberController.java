package com.kh.boot.controller;

import com.kh.boot.domain.vo.Member;
import com.kh.boot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {

    /*
    Di(Dependency Injection) - 의존성 주입

    스프링부트의 가장 큰 특징이자 코드 결합도가 낮아지고 코드를 분리하기 위함!!

    @Autowired
    의존성주입을 사용할 때 사용하는 어노테이션
    클래스내에서 필요한 개체를 직접 생성하지 않고 spring컨테이너가 관리하는 객체(Bean에 등록)를 주입받아서 사용할 수 있게 해줌


    기존 객체 생성방식 -> 객체간의 결합도가 높아짐(소스코드 수정이 일어날 경우 하나하나 전부 바꿔줘야한다.)
    서비스가 동시에 매우 많은 요청이 될 경우 그 만큼 객체가 생성된다.

    필드주입방식
    스프링 컨테이너가 객체를 생성 후, @Autowired붙은 필드에 의존성을 주입해주는 방식
    장점 : 간결하다. 따로 생성자나 setter를 작성하지 않아도 된다.
    단점 : 테스트 어려움(필드주입방식은 객체생성시 의존성이 주입되지 않고 been에서 생성 후 주입하는 방식이기 때문에
                      테스트 진행시 임의에 객체를 생성하기 어렵다)
          불변성을 보장할 수 없음. 객체생성시 의존성이 주입되어 고정되지 않기 때문에 클래스 생성 이후에 의존성이 변경될 수 있음

    생성자주입방식
    스프링 컨테이너가 객체를 생성할 때 @Autowired 어노테이션이 붙은 생성자를 통해 필요한 의존성을 주입하는 방식
    장점 : 불변성이 보장, 테스트가 편리하다. 순환참조방지

    */


    /*
    * 필드주입방식
    * @Autoweired
    * private MemberService memberService
    * */

    /*생성자 주입방식
    * 아래의 방법으로 작성할 수 있고,
    * 클래스에 어노테이션 + 필드 작성해서도 사용가능
    * 클래스 : @RequiredArgsConstructor
    * 필드 : private final MemberService memberService;
    */
    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public MemberController(MemberService memberService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberService = memberService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("login.me")
    public ModelAndView login(@ModelAttribute Member member, ModelAndView mv, HttpSession session){

        Member loginMember = memberService.loginMember(member.getUserId());

        //lginmember의 userPwd --> 암호화된 userPwd
        //member의 userPwd ---> 암호화 전의 userPwd(평문)
        //bCryptPasswordEncoder.matches(평문,암호문) --> 해당 비밀번호가 암호화된 비밀번호와 일치하면 true 아니면 false q반환
        //bCryptPasswordEncoder.matches(member.getUserPwd(),loginMember.getUserPwd());

        if(loginMember == null){
            mv.addObject("errorMsg","아이디를 찾을 수 없습니다.");
            mv.setViewName("common/errorPage");
        } else if (!bCryptPasswordEncoder.matches(member.getUserPwd(),loginMember.getUserPwd())) {
            mv.addObject("errorMsg","비밀번호가 일치하지 않습니다.");
            mv.setViewName("common/errorPage");
        } else{
            session.setAttribute("loginUser",loginMember);
            mv.setViewName("redirect:/");
        }

        return mv;
    }

    @GetMapping("logout.me")
    public String logout(HttpSession session){
        session.setAttribute("alertMsg","로그아웃 완료");
        session.removeAttribute("loginUser");

        return "redirect:/";
    }

    @GetMapping("enrollForm.me")
    public String enrollForm(){
        return "member/memberEnrollForm";
    }

    @PostMapping ("insert.me")
    public String insertMember(Member member, HttpSession session, Model model){
        /*
        * age 값은 int로 필드로 구성할 경우 빈문자열이 전달되면 형변환 과장엣 400에러가 발생
        * 보통 400 에러는 보내는 데이터와 받는 데이터의 타입이 일치하지 않을 때 발생한다.
        *
        * 비밀번호를 사용자 입력 그대로 저장한다.(평문)
        * Bcrypt방식을 이용해서 암호화작업 후 저장함
        * -> 스프링 시큐리티에서 제공하는 모듈을 이용(pom.xml에 라이브러리 추가 후 빈에 객체등록)
        * */
        String pwd = bCryptPasswordEncoder.encode(member.getUserPwd());
        member.setUserPwd(pwd);

        int reuslt = memberService.insertMember(member);
        if(reuslt >0){
            session.setAttribute("alterMsg","성공적으로 회원가입을 완료하였습니다.");
            return "redirect:/";
        }else{
            model.addAttribute("alertMsg","성공적으로 회원가입을 완료하였습니다.");
            return "common/errorPage";
        }

    }
    @GetMapping("myPage.me")
    public String myPage(){
        return "member/memberMyPage";
    }

}

