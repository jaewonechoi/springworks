package com.khit.todoweb.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor	//기본생성자
@AllArgsConstructor	//파라미터가 있는 생성자
@Data	//Getter, Setter, ToString
public class TodoVO {
	//필드
	private Long tno;
	private String title;
	private String writer;
	private Timestamp createdDate;
}
