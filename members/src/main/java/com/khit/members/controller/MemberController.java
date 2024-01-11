package com.khit.members.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.members.dto.MemberDTO;
import com.khit.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor	//생성자 주입 
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/join")
	public String joinForm() {
		
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		log.info("memberDTO= " + memberDTO);
		memberService.insert(memberDTO);
		return "/member/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember != null) {
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			log.info("로그인 성공" + memberDTO.getEmail());
			log.info("loginMember= " + loginMember);
			return "index";
		}else {
			return "/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	//모든 세션 삭제
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String getList(Model model) {
		List<MemberDTO> memberDTOList =  memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		return "/member/list";
	}
	
	/*@GetMapping("/detail")
	public String memberView(HttpSession session, Model model) {
		String sessionEmail = (String)session.getAttribute("sessionEmail");
		MemberDTO memberDTO = memberService.findByEmail(sessionEmail);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}*/
	
	//회원 정보
	@GetMapping
	public String getMember(@RequestParam("id")Long id, Model model) {
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}
	
	//회원 수정
	@GetMapping("/update")
	public String updateForm(HttpSession session, Model model) {
		String sessionEmail = (String)session.getAttribute("sessionEmail");
		MemberDTO memberDTO = memberService.findByEmail(sessionEmail);
		model.addAttribute("member", memberDTO);
		return "/member/update";
	}
	
	//수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		memberService.update(memberDTO);
		return "redirect:/member?id=" + memberDTO.getId();
	}
	
	//회원 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id")Long id) {
		memberService.delete(id);
		return "redirect:/member/list";
	}
	
	//이메일 중복 검사
	@PostMapping("/checkemail")
	public @ResponseBody String checkEmail(@RequestParam("email") String email) {
		String resultText = memberService.checkEmail(email);
		return resultText;	//"OK" 또는 "NO"가 반환됨
	}
}
