package com.kh.boot.domain.vo;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Board {

    private int boardNo;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private String originName;
    private String changeName;
    private String count;
    private String createDate;
    private String status;
    private int boardType;
    private List<MultipartFile> files = new ArrayList<>();




}
