package com.myspring.musicnerd.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.musicnerd.dao.MemberDAO;
import com.myspring.musicnerd.service.MemberService;
import com.myspring.musicnerd.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@Inject
	MemberDAO memberDAO;
	
	// 회원가입
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberVO memberVO) {
		
		System.out.println("아이디 : " + memberVO.getId());
		System.out.println("비번 : " + memberVO.getPw());
		System.out.println("닉네임 : " + memberVO.getNickname());
		memberDAO.insert(memberVO);
		return "redirect:/";
	}
	
	
	// 로그인
	@RequestMapping("member/login_check.do")
	public String login_check(@ModelAttribute MemberVO memberVO, HttpSession session) {
		
		String nickname = memberService.loginCheck(memberVO, session);
		
		return "redirect:/";
	}
	
	
	// 로그아웃 (세션 삭제)
	@RequestMapping("member/logout.do")
	public String login_check(HttpSession session) {
		memberService.logout(session);
		return "redirect:/";
	}
	
	
	// 아이디 중복확인
	@RequestMapping(value = "member/join/idduplexcheck", method = RequestMethod.GET)
	@ResponseBody
	public int id_duplex_check(@RequestParam("id") String id) {
		System.out.println(id);
		System.out.println("리턴 : " + memberService.userIdCheck(id));
		return memberService.userIdCheck(id);
	}
	
	// 닉네임 중복확인
	@RequestMapping(value = "member/join/nickduplexcheck", method = RequestMethod.GET)
	@ResponseBody
	public int nick_duplex_check(@RequestParam("nick") String nick) {
		System.out.println(nick);
		System.out.println("리턴 : " + memberService.userNickCheck(nick));
		return memberService.userNickCheck(nick);
	}
	
}
