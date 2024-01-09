package com.khit.todoweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Controller
@RequestMapping("/todo")
public class TodoController {
	
	private TodoService todoService;
	
	@GetMapping("/register")
	public String registerForm() {
		
		return "/todo/register";
	}
	
	//등록
	@PostMapping("/register")
	public String register(@ModelAttribute TodoDTO todoDTO) {
		log.info("todoDTO" + todoDTO);
		todoService.insert(todoDTO);
		return "redirect:/todo/list";
	}
	
	//목록보기
	@GetMapping("/list")
	public String todoList(Model model) {
		List<TodoDTO> todoDTOList =  todoService.findAll();
		model.addAttribute("todoList", todoDTOList);
		
		return "/todo/list";
	}
	
	@GetMapping("/paging")
	public String todoPagingList(@ModelAttribute PageRequestDTO pageRequestDTO,
			Model model) {
		PageResponseDTO<TodoDTO> pageResponseDTO = 
				todoService.pagingList(pageRequestDTO);
		model.addAttribute("responseDTO", pageResponseDTO);
		return "/todo/pagelist";
	}
	
	//1건 상세보기	-	//todo?tno=1
	@GetMapping
	public String todoDetail(@RequestParam("tno") Long tno, Model model,
			PageRequestDTO pageRequestDTO) {
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "todo/detail";
	}
	
	//수정페이지 요청
	@GetMapping("/update")
	public String updateForm(@RequestParam("tno")Long tno, Model model) {
		//해당 할일 가져오기
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "todo/update";
	}
	
	//수정처리
	@PostMapping("/update")
	public String update(@ModelAttribute TodoDTO todoDTO) {
		todoService.update(todoDTO);
		return "redirect:/todo/update?tno=" + todoDTO.getTno();
	}
	
	//삭제하기
	@GetMapping("/delete")
	public String delete(@RequestParam("tno")Long tno) {
		
		todoService.delete(tno);
		return "redirect:/todo/list";
	}
}
