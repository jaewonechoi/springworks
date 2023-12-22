package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString			//객체의 정보를 문자열로 출력
@NoArgsConstructor		//기본 생성자
@AllArgsConstructor		//매개변수가 있는 생성자
@Getter
@Setter
public class UserDTO {
	//필드
	private String name;
	private int age;
}
