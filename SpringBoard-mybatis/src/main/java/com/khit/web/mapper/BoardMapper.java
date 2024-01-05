package com.khit.web.mapper;

import java.util.List;
import java.util.Map;

import com.khit.web.dto.BoardDTO;

public interface BoardMapper {

	void insert(BoardDTO boardDTO);	//글쓰기

	List<BoardDTO> findAll();	//글목록

	BoardDTO findById(Long id);	//글상세보기

	void updateHit(Long id);

	BoardDTO findByUserId(String userId);

	void update(BoardDTO boardDTO);

	void delete(Long id);

	List<BoardDTO> pagingList(Map<String, Integer> pagingParam);

	int boardCount();

}
