package com.kh.boot.domain.vo;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Photoboard {
    private int photoNo;
    private String photoTitle;
    private String photoWriter;
    private String photoContent;
    private String originName;
    private String changeName;
    private int count;
    private String createDate;
    private String status;
    private List<MultipartFile> upfile;
}
