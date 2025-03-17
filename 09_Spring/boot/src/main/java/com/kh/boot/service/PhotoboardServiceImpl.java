package com.kh.boot.service;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Photoboard;
import com.kh.boot.mappers.PhotoboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class PhotoboardServiceImpl implements PhotoboardService {

    private final PhotoboardMapper photoboardMapper;


    @Override
    public ArrayList<Photoboard> photoBoard() {

        return photoboardMapper.photoBoard();
    }

    @Override
    @Transactional
    public int insertAttachment(Photoboard pboard, Attachment[] files) {

        int result1 = 1;
        int photoNo = photoboardMapper.insertPboard(pboard);

        if(photoNo > 0){
            for (Attachment file : files) {
                result1 *= photoboardMapper.insertAttachment(file);
            }
        }
        int result = result1 >0 & photoNo >0? photoNo : 0;


        return result;
    }
}
