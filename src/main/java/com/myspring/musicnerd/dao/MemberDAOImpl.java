package com.myspring.musicnerd.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.musicnerd.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// 마이바티스 호출
	@Inject
	private SqlSession sqlSession;

	
	// 회원가입
	@Override
	public void insert(MemberVO memberVO) {
		sqlSession.insert("memberMapper.insert", memberVO);
	}

	// 로그인 유저 확인
	@Override
	public String loginCheck(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.login_check", memberVO); 
	}
	
	// 회원가입 - 아이디 중복확인
	@Override
	public int id_duplex_Check(String id) {
		return sqlSession.selectOne("memberMapper.id_duplex_check", id); 
	}
	
	// 회원가입 - 닉네임 중복확인
	@Override
	public int nick_duplex_Check(String nick) {
		return sqlSession.selectOne("memberMapper.nick_duplex_check", nick);
	}


	
}
