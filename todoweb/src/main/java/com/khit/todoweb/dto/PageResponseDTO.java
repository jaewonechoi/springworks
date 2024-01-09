package com.khit.todoweb.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDTO<E> { //목록과 페이지 이동을 위한 DTO
	//제네릭으로 만드는 이유 - 회원정보, 게시판 객체를 페이지 처리할 수 있음 
	private int page;
	private int size;
	private int total;
	
	//시작페이지 번호
	private int startPage;
	//마지막 페이지
	private int endPage;
	
	//이전 페이지 존재 여부
	private boolean prev;
	//다음 페이지 존재 여부
	private boolean next;
	
	//목록 데이터
	private List<E> dtoList;
	
	//생성자
	@Builder(builderMethodName = "withAll")
	public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		
		this.total = total;
		this.dtoList = dtoList;
		
		//하단 - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		this.endPage = (int)(Math.ceil((double)this.page/10)) * 10;
		this.startPage = this.endPage - 9;
		
		//total - 83
		int maxPage = (int)(Math.ceil((double)total/size));
		if(endPage >= maxPage)
			endPage = maxPage;
		
		//이전
		this.prev = this.startPage > 1;
		//다음
		this.next = total > (this.endPage * this.size);
	}
}
