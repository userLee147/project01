package com.kh.boot.mappers;


import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Photoboard;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PhotoboardMapper {



    ArrayList<Photoboard> photoBoard();

    int insertPboard(Photoboard pboard);
    int insertAttachment(Attachment file);
}
