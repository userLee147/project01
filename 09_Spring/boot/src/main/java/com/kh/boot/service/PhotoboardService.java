package com.kh.boot.service;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.domain.vo.Photoboard;

import java.util.ArrayList;


public interface PhotoboardService {

    ArrayList<Photoboard> photoBoard();
    int insertAttachment(Photoboard pboard, Attachment[] files);
}
