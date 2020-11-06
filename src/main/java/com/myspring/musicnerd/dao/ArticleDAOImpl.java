package com.myspring.musicnerd.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.musicnerd.vo.ArticleVO;

@Repository
public class ArticleDAOImpl implements ArticleDAO{

	// 마이바티스 호출
	@Inject
	private SqlSession sqlSession;
	
	// 게시글 추가
	@Override
	public void insert(ArticleVO articleVO) {
		sqlSession.insert("articleMapper.insert", articleVO);
		
	}

	// 게시글 목록 조회
	@Override
	public List<ArticleVO> list() throws Exception {
		return sqlSession.selectList("articleMapper.select");
	}

	// 무한스크롤
	@Override
	public List<ArticleVO> list(Map<String, Integer> list) throws Exception {
		return sqlSession.selectList("articleMapper.infinite", list);
	}



	



}
