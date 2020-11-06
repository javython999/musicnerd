package com.myspring.musicnerd.service;

import javax.servlet.http.HttpSession;

import com.myspring.musicnerd.vo.MemberVO;

public interface MemberService {
	public String loginCheck(MemberVO memberVO, HttpSession	session);
	public void logout(HttpSession session);
	public int userIdCheck(String id);
	public int userNickCheck(String nick);
}
