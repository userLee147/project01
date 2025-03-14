package com.kh.boot.RESTController;

import com.kh.boot.domain.vo.Reply;
import com.kh.boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")

public class APIBoardController {

    private final BoardService boardService;

    /*
    @PostMapping("/")
    public String insertReplytest(@RequestBody Reply r){

        //System.out.println("controller :" + r);


        int result = boardService.insertRely(r);
        if(result >0){
            return "success";
        }else {
            return "fail";
        }
    }
     */

    @PostMapping("/reply")
    public String insertReply(Reply r){

        int result = boardService.insertRely(r);
        if(result >0){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/replylist")
    public ArrayList<Reply> getReplyList(int boardNo){
        ArrayList<Reply> list = boardService.getReplyList(boardNo);
        return list;
        // 스프링이 jackson(gSON이랑 비슷한..?)을 가지고 있기 때분에 객체 -> String으로 변환하는 "직렬화"를 할 수 있음
    }
}
