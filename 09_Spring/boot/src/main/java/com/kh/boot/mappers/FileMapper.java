package com.kh.boot.mappers;

import com.kh.boot.domain.vo.Attachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface FileMapper {
    /*
    * 파일 정보 저장
    * @param files - 파일정보리스트
    * */
    void saveAll(List<Attachment> files);
}
