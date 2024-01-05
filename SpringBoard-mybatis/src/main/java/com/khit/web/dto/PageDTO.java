package com.khit.web.dto;

import lombok.Data;

@Data
public class PageDTO {
	private int page;		//현재 페이지
	private int maxPage;	//최대 페이지(총 글개수에 따른 페이지)
	private int startPage;	//현재 페이지 기준 시작 페이지 값
	private int endPage;	//현재 페이지 기준 마지막 페이지 값
}
