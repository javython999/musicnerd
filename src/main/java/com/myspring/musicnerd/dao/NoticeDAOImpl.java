package com.myspring.musicnerd.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.musicnerd.vo.NoticeVO;


@Repository
public class NoticeDAOImpl implements NoticeDAO {

	// 마이바티스 호출
	@Inject
	private SqlSession sqlSession;
	
	
	// 공지글 목록 조회
	@Override
	public List<NoticeVO> list() throws Exception {
		return sqlSession.selectList("noticeMapper.select");
	}

	// 공지글 추가
	@Override
	public void insert(NoticeVO noticeVO) {
		sqlSession.selectList("noticeMapper.insert", noticeVO);
	}

}
