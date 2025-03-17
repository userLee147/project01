package com.kh.boot.domain.vo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    private int fileNo;
    private int refBno;
    private String originName;
    private String changeName;
    private long fileSize;

    @Builder
    public Attachment(String originName, String changeName, long fileSize) {
        this.originName = originName;
        this.changeName = changeName;
        this.fileSize = fileSize;
    }

    public void setBoardNo(int refBno) {
        this.refBno = refBno;
    }

}
