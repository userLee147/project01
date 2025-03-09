package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Reply {
	private int replyNo;
	private String replyContent;
	private int refBno;
	private int replyWriter;
	private Date createDate;
	private String status;
	
	private String userId;

}
