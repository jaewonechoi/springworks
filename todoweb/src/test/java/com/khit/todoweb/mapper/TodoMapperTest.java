package com.khit.todoweb.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.vo.TodoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoMapperTest {
	
	@Autowired	//�ڵ����� - todoMapper�� new�ѰͰ� ����
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime()); 
	}
	
	/*@Test
	public void testInsert() {
		//������ 1�� ���� - setter -> builder()
		
		TodoVO todoVO = new TodoVO();
		//todoVO.setTno(1L);
		todoVO.setTitle("�����");
		todoVO.setWriter("����Ŵ");
		//todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/
		
		/*TodoVO todoVO = TodoVO.builder()
				.title("20�� ��ϱ�")
				.writer("�쿵��")
				.build();
		
		todoMapper.insert(todoVO);
	}*/
	@Test
	public void testFindAll() {
		List<TodoVO> todoList = todoMapper.findAll();
		
		/*for(TodoVO todo : todoList) {
			log.info(todo);
		}*/
		
		//todoList.forEach(todo -> log.info(todo));
	}
	
	@Test
	public void testFindById() {
		//db���� 1�� ������ �˻�
		TodoVO todoVO = todoMapper.findById(1L);
		//log.info(todoVO);
	}
	
	/*@Test
	public void testDelete() {
		todoMapper.delete(10L);
		log.info("���� ����");
	}*/
	
	/*@Test
	public void testUpdate() {
		TodoVO todoVO = todoMapper.findById(3L);
		todoVO.setTitle("����");
		
		todoMapper.update(todoVO);
	}*/
	
	/*@Test
	public void testPagingList() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(2)
				.size(10)
				.build();
		
		List<TodoVO> todoList = todoMapper.pagingList(pageRequestDTO);
		for(TodoVO todo : todoList) {
			log.info(todo);
		}
	}*/
	
	@Test
	public void testSelectSearch() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.types(new String[] {"t", "w"})
				.keyword("�����ϱ�")
				.build();
		
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		
		for(TodoVO todoVO : voList) {
			log.info(todoVO);
		}
	}
}
