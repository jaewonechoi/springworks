package com.khit.web.dto;

import lombok.Data;

@Data
public class PageDTO {
	private int page;		//���� ������
	private int maxPage;	//�ִ� ������(�� �۰����� ���� ������)
	private int startPage;	//���� ������ ���� ���� ������ ��
	private int endPage;	//���� ������ ���� ������ ������ ��
}
