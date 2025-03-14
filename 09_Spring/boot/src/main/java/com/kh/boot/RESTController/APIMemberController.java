package com.kh.boot.RESTController;

import com.kh.boot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class APIMemberController {

    private final MemberService memberService;


    @GetMapping("/id")
    public String checkMemberId(String checkId){
        int result = memberService.idCheck(checkId);
        if(result > 1){
            return "NNNNN";
        }else{
            return "NNNNY";
        }

    }

}
