package com.kh.boot.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
// 세터가 있어야 잘 들어감 ㅜㅜㅜ

public class Reply {
    private int replyNo;
    private String replyContent;

    @JsonIgnore // 이필드는 json으로 변환할 때 포함x
    private int refBno;

    private String replyWriter;
    private String createDate;

    @JsonIgnore
    private String status;
}
