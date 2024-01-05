package com.khit.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.mapper.BoardMapper;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}

	@Override
	public List<BoardDTO> findAll() {
		return boardMapper.findAll();
	}

	@Override
	public BoardDTO findById(Long id) {
		return boardMapper.findById(id);
	}

	@Override
	public void updateHit(Long id) {
		boardMapper.updateHit(id);
	}

	@Override
	public BoardDTO findByUserId(String userId) {
		return boardMapper.findByUserId(userId);
	}

	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
	}

	@Override
	public void delete(Long id) {
		boardMapper.delete(id);
	}
	
	int pageLimit = 10;	//�������� �� ����
	int blockLimit = 5;	//�ϴܿ� ��µ� ������ ��ȣ ����
	@Override
	public List<BoardDTO> pagingList(int page) {
		/*
	 	  1page(0, 5), 2page(5, 5), page3(10,5)
		  select * from boards order by id desc limit 0, 5;
		*/
		
		int pageStart = (page - 1) * pageLimit;	//������ ���� ��ȣ
		
		Map<String, Integer> pagingParam = new HashMap<>();
		pagingParam.put("start", pageStart);
		pagingParam.put("limit", pageLimit);
		
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam);
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		//�ϴܿ� ��µ� ������ ��
		int totalRow = boardMapper.boardCount();	//�Խñ� ��
		//��ü ������ ���� - �ø�(Math.ceil) 43/10 = 4.3 -> 5.3 -> 5(int)
		int maxPage = (int)(Math.ceil((double)totalRow / pageLimit));
		//�ϴܿ� ��µ� ���� ������ �� ��� - ����)5���� ���� (1, 6, 11, 16, ...)
		int startPage = ((int)(Math.ceil((double)page/ blockLimit))-1) * blockLimit + 1;
		//�ϴܿ� ��µ� ������ ������ �� ���(5, 10, 15, 20, ...)
		int endPage = startPage + blockLimit - 1;
		if(endPage > maxPage) 
			endPage = maxPage;
		
		//pageDTO ��ü�� �����ؼ� ���� ������ �ְ� ��ȯ��
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		
		return pageDTO;
	}
}
