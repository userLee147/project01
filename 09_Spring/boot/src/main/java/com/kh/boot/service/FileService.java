package com.kh.boot.service;

import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.mappers.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileMapper fileMapper;

    @Transactional // board와 attachment가 동시에 일어나니까 수동으로 해야 할 것 같음
    public void saveFiles(int refBno, List<Attachment> files){
        if(CollectionUtils.isEmpty(files)){
            return; // 첨부파일이 list가 없으면 함수 종료
        }
        for(Attachment file : files){
            file.setBoardNo(refBno); // 첨부파일 list가 존재하면 boardNo을 넣는다....
        }
        fileMapper.saveAll(files);
    }
}
