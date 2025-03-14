package com.kh.boot.controller;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Board;
import com.kh.boot.service.AttachmentService;
import com.kh.boot.service.BoardService;
import com.kh.boot.service.FileService;
import com.kh.boot.utils.FileUtils;
import com.kh.boot.utils.Template;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RequiredArgsConstructor
@Controller
public class AttachmentController {

    private final BoardService boardService;
    private final FileService fileService;
    private final FileUtils fileUtils;
    private final AttachmentService attachmentService;

    @GetMapping("photo.bo")
    public String photoview(Model model) {
        ArrayList<Board> list = boardService.photoBoard();

        model.addAttribute("list", list);
        return "photo/photoListView";
    }



    @RequestMapping("enrollForm.pt")
    public String enrollForm(Model model){
        return "photo/photoEnrollForm";
    }
    /*
    @PostMapping("save.ph")
    public String savePost(@ModelAttribute Board board, HttpSession session, Model model){

        MultipartFile upfile = board.getFiles().get(0);

        if(!upfile.getOriginalFilename().equals("")){
            String changName = Template.saveFile(upfile, session,"/resources/uploadfile/" );
            board.setChangeName("/resources/uploadfile/"+changName);
            board.setOriginName(upfile.getOriginalFilename());
        }



        int result = boardService.insertBoard(board);

        List<Attachment> files = fileUtils.uploadFiles(board.getFiles());


        if(result >0){
            fileService.saveFiles(board.getBoardNo(),files);
        }
        return "photo/photoListView";
    }

    */

    @PostMapping("save.ph")
    public String savePost(@ModelAttribute MultipartFile[] upfile, Board board, HttpSession session, Model model) {

        System.out.println(board);

        Attachment[] files = new Attachment[upfile.length];

        for (int i = 0; i < upfile.length; i++) {
            files[i].setOriginName(upfile[i].getOriginalFilename());
            files[i].setChangeName(Template.saveFile(upfile[i],session,"/resources/upload/"));

        }

        int result = attachmentService.insertAttachment(files);


        return "photo/photoListView" ;
    }

}
