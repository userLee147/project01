package com.kh.boot.service;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.mappers.AttachmentMapper;
import com.kh.boot.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentMapper attachmentMapper;
    //private final BoardMapper boardMapper;

    @Override
    public int insertAttachment(Attachment[] files) {

        int result = 1;

        //boardMapper.insertBoard(board)
        for (Attachment file : files) {
            result *= attachmentMapper.insertAttachment(file);

        }
        return result;
    }
}
