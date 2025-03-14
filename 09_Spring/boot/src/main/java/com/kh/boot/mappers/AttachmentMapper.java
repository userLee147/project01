package com.kh.boot.mappers;


import com.kh.boot.domain.vo.Attachment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachmentMapper {
    int insertAttachment(Attachment file);
}
