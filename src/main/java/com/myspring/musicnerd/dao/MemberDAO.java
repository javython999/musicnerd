package com.myspring.musicnerd.dao;

import com.myspring.musicnerd.vo.MemberVO;

public interface MemberDAO {
	public void insert(MemberVO memberVO);
	public String loginCheck(MemberVO memberVO);
	int id_duplex_Check(String id);
	int nick_duplex_Check(String nick);
}
