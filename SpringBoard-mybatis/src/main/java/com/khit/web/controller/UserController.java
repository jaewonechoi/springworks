package com.khit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {
	
	//회원가입 페이지 요청
	@GetMapping("/join")
	public String joinForm() {
		return "/user/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute UserDTO userDTO) {
		log.info("userDTO" + userDTO);
		return "redirect:/";	//http://localhost:8080/
	}
	
}
