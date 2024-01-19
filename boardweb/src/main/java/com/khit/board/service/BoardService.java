package com.khit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khit.board.dto.BoardDTO;
import com.khit.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;

	public void insert(BoardDTO boardDTO) {
		boardRepository.insert(boardDTO);
	}

	public List<BoardDTO> findAll() {
		return boardRepository.findAll();
	}

	public BoardDTO findById(Integer id) {
		return boardRepository.findById(id);
	}

	public void delete(Integer id) {
		boardRepository.delete(id);
	}

	public void update(BoardDTO boardDTO) {
		boardRepository.update(boardDTO);
	}
}
