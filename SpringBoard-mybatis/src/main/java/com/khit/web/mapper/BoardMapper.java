package com.khit.web.mapper;

import java.util.List;

import com.khit.web.dto.BoardDTO;

public interface BoardMapper {

	void insert(BoardDTO boardDTO);	//글쓰기

	List<BoardDTO> findAll();	//글목록

	BoardDTO findById(Long id);	//글상세보기

}
