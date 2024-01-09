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
	
	//���
	@PostMapping("/register")
	public String register(@ModelAttribute TodoDTO todoDTO) {
		log.info("todoDTO" + todoDTO);
		todoService.insert(todoDTO);
		return "redirect:/todo/list";
	}
	
	//��Ϻ���
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
	
	//1�� �󼼺���	-	//todo?tno=1
	@GetMapping
	public String todoDetail(@RequestParam("tno") Long tno, Model model,
			PageRequestDTO pageRequestDTO) {
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "todo/detail";
	}
	
	//���������� ��û
	@GetMapping("/update")
	public String updateForm(@RequestParam("tno")Long tno, Model model) {
		//�ش� ���� ��������
		TodoDTO todoDTO = todoService.findById(tno);
		model.addAttribute("todo", todoDTO);
		return "todo/update";
	}
	
	//����ó��
	@PostMapping("/update")
	public String update(@ModelAttribute TodoDTO todoDTO) {
		todoService.update(todoDTO);
		return "redirect:/todo/update?tno=" + todoDTO.getTno();
	}
	
	//�����ϱ�
	@GetMapping("/delete")
	public String delete(@RequestParam("tno")Long tno) {
		
		todoService.delete(tno);
		return "redirect:/todo/list";
	}
}