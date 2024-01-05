package com.khit.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String wrtie(BoardDTO boardDTO) {
		log.info("boardDTO " + boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/board/paging";	//boardlist.jsp로 이동
	}
	
	//글목록
	// /board/
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList =  boardService.findAll();
		model.addAttribute("boardList", boardDTOList);
		return "/board/pagelist";
	}
	
	//글목록(페이지처리)
	// /board/paging?page=2
	// @RequestParam(required=true/false) false는 필수 아님
	@GetMapping("/paging")
	public String getPageList(@RequestParam(value="page", 
	required=false, defaultValue="1") int page, Model model) {
		log.info("page" + page);
		
		//페이지와 글 개수를 구현된 목록 보기
		List<BoardDTO> pagingList = boardService.pagingList(page);
		log.info("page=" + pagingList);
		model.addAttribute("boardList", pagingList);
		
		//화면 하단 구현
		PageDTO pageDTO = boardService.pagingParam(page);
		model.addAttribute("paging", pageDTO);
		
		return "/board/pagelist";
	}
	
	//글 상세보기
	// /board?id=
	@GetMapping
	public String getBoard(@RequestParam("id") Long id, Model model, 
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		//조회수 증가
		boardService.updateHit(id);
		//글 상세보기
		BoardDTO boardDTO = boardService.findById(id);
		//댓글 목록 보기
		List<ReplyDTO> replyDTOList = replyService.getReplyList(id);
		
		model.addAttribute("board", boardDTO);
		model.addAttribute("replyList", replyDTOList);
		model.addAttribute("page", page);
		
		return "/board/detail";	//detail.jsp
	}
	
	//글삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";	//글 목록으로 이동
	}
	
	//글 수정페이지 가져오기
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") Long id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "board/boardupdate";
	}
	/*
	 * @GetMapping("/update") public String updateForm(Model model, HttpSession
	 * session) { String userId = (String)session.getAttribute("sessionId");
	 * session.getAttribute(userId); BoardDTO boardDTO =
	 * boardService.findByUserId(userId); model.addAttribute("board", boardDTO);
	 * return "/board/boardupdate"; }
	 */
	
	//글 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		//수정해서 다시 저장함(객체[DTO]로 저장)
		boardService.update(boardDTO);
		return "redirect:/board/update?id=" + boardDTO.getId();
	}
	
	/*
	 * @PostMapping("/update") public String updateBoard(@ModelAttribute BoardDTO
	 * boardDTO) { boardService.update(boardDTO); return
	 * "redirect:/board/update?id=" + boardDTO.getId(); }
	 */
}