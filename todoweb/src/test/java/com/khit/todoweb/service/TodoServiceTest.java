package com.khit.todoweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoServiceTest {
	
	@Autowired
	private TodoService todoService;
	
	@Test
	public void testinsert() {
		//폼에 입력된 자료로 간주해서 db에 저장
		TodoDTO todoDTO = TodoDTO.builder()
				.title("취업하기")
				.writer("이강인")
				.build();
		
		todoService.insert(todoDTO);
	}
	
	@Test
	public void testPaging() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();
		
		PageResponseDTO<TodoDTO> responseDTO = todoService.pagingList(pageRequestDTO);
		log.info(responseDTO);
		
		responseDTO.getDtoList().stream().forEach(todo -> log.info(todo));
	}
	
}
