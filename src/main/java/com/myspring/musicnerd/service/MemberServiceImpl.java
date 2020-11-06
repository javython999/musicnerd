package com.myspring.musicnerd.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.myspring.musicnerd.dao.MemberDAO;
import com.myspring.musicnerd.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDAO;
	
	// 로그인
	@Override
	public String loginCheck(MemberVO memberVO, HttpSession session) {
		
		// 가입된 유저이면 닉네임이 넘어오고 틀리면 null이 넘어옴
		String nickname = memberDAO.loginCheck(memberVO);
		
		if(nickname != null) {// 맞으면
			// 세션에 등록
			session.setAttribute("user_nickname", nickname);
			session.setAttribute("user_id", memberVO.getId());
		} else {
			System.out.println("로그인 실패");
		}
		return nickname;
	}
	
	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		// 세션을 모두 초기화 시킴
		session.invalidate();
	}

	// 회원가입 - 아이디 중복확인
	@Override
	public int userIdCheck(String id) {
		return memberDAO.id_duplex_Check(id);
	}
	
	// 회원가입 - 아이디 중복확인
	@Override
	public int userNickCheck(String nick) {
		return memberDAO.nick_duplex_Check(nick);
	}
	

}
