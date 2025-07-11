package org.mbc.domain;


import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
// 객체용. 읽기 전용 속성이 강함
	// dto는 게터세터 모두 가지고 활용하는 객체
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date updateDate;
	private Date regDate;
	
}
