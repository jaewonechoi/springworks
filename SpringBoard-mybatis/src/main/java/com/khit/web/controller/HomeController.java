package com.khit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/global_error")
	public String error() {
		return "/exception/global_error";
	}
	
	// "/"rudfhdptj 404 에러 발생
	// @ResponseBody - json(문자) 데이터 반환
	@GetMapping("favicon.ico")
	@ResponseBody
	public void returnNoFavicon() {
		
	}
}
