package com.kh.boot.controller;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Board;
import com.kh.boot.domain.vo.Photoboard;
import com.kh.boot.service.PhotoboardService;
import com.kh.boot.service.BoardService;
import com.kh.boot.service.FileService;
import com.kh.boot.utils.FileUtils;
import com.kh.boot.utils.Template;
import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RequiredArgsConstructor
@Controller
public class PhotoboardController {

    private final BoardService boardService;
    private final FileService fileService;
    private final FileUtils fileUtils;
    private final PhotoboardService photoboardService;




    @GetMapping("photo.bo")
    public String photoview(Model model) {
        ArrayList<Photoboard> list = photoboardService.photoBoard();

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
    public String savePost(@ModelAttribute Photoboard pboard, HttpSession session, Model model) {
        System.out.println("pboard"+ pboard);

        Attachment[] files = new Attachment[pboard.getUpfile().size()];
        if(files != null){

            for (int i = 0; i < files.length; i++) {

                files[i].setOriginName(pboard.getUpfile().get(i).getOriginalFilename());
                files[i].setChangeName(Template.saveFile(pboard.getUpfile().get(i),session,"/resources/upload/"));
                if(i == 0){
                    pboard.setOriginName(files[0].getOriginName());
                    pboard.setChangeName(files[0].getChangeName());
                }
            }

        }
        int result = photoboardService.insertAttachment(pboard, files);


        if(result >0){
            session.setAttribute("alertMsg" ,"게시글 등록 성공");
        } else{
            model.addAttribute("errorMsg","게시글 등록 실패");
            return "redirect:/";
        }
        return "photo/photoListView" ;
    }

}
