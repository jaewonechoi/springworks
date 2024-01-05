package com.khit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	//서비스 클래스 주입(생성자, Autowired)
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("insert")
	public String replyInsert(@ModelAttribute ReplyDTO replyDTO) {
		//댓글 폼에 입력된 데이터 출력
		log.info("replyDTO" + replyDTO);
		//댓글 저장 처리
		replyService.insert(replyDTO);
		return "redirect:/board?id=" + replyDTO.getBoardId();
	}
}
