package com.kh.boot.service;

import com.kh.boot.domain.vo.Attachment;
import org.springframework.stereotype.Service;


public interface AttachmentService {

    int insertAttachment(Attachment[] files);
}
