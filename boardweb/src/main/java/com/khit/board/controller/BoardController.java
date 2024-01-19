package com.khit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.board.dto.BoardDTO;
import com.khit.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		System.out.println(boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/board/list";
	}
	
	//목록 보기
	@GetMapping("/list")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList", boardDTOList);
		return "/board/list";
	}
	
	//상세보기
	@GetMapping("/detail")
	public String getBoard(@RequestParam("id")Integer id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Integer id) {
		boardService.delete(id);
		return "redirect:/board/list";
	}
	
	@GetMapping("/update")
	public String updateForm(@RequestParam("id")Integer id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board/detail?id=" + boardDTO.getId();
	}
}
