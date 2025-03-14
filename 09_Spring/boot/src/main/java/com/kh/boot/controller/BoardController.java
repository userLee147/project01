package com.kh.boot.controller;

import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.service.BoardService;
import com.kh.boot.utils.Template;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLOutput;
import java.util.ArrayList;


@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping ("list.bo")
    public String selectBoardList(@RequestParam(defaultValue ="1") int cpage, Model model){
        int boardCount = boardService.selectBoardCount();

        PageInfo pi = new PageInfo(boardCount,cpage,10,5);

        ArrayList<Board> list = boardService.selectBoardList(pi);

        model.addAttribute("list",list);
        model.addAttribute("pi",pi);

        return "board/boardListView";
    }

    @GetMapping("detail.bo")
    public String selectBoard(@RequestParam( value = "bno") int boardNo, Model model){
        Board b = boardService.selectBoard(boardNo);
        model.addAttribute("b",b);


        return "board/boardDetailView";
    }

    @RequestMapping("enrollForm.bo")
    public String enrollForm(){
        return "board/boardEnrollForm";

    }
    @PostMapping("insert.bo")
    public String insertBoard(@ModelAttribute Board board, MultipartFile upfile, HttpSession session, Model model){
        System.out.println(upfile);

        if(!upfile.getOriginalFilename().equals("")){
            String changName = Template.saveFile(upfile, session,"/resources/uploadfile/" );
            board.setChangeName("/resources/uploadfile/"+changName);
            board.setOriginName(upfile.getOriginalFilename());
        }


        int result = boardService.insertBoard(board);

        if(result >0){
            session.setAttribute("alertMsg","게시글 작성 성공");
            return "redirect:/list.bo";
        }else{
            model.addAttribute("errorMsg","게시글 작성 실패");
            return "common/errorPage";
        }

    }

}
