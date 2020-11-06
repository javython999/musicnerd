package com.myspring.musicnerd.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myspring.musicnerd.dao.ArticleDAO;
import com.myspring.musicnerd.vo.ArticleVO;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Inject
	private ArticleDAO articleDAO;
	
	// 게시글 목록 조회
	@Override
	public List<ArticleVO> list() throws Exception {
		return articleDAO.list();
	}

	// 무한스크롤
	@Override
	public List<ArticleVO> list(Map<String, Integer>  list) throws Exception {
		return articleDAO.list(list);
	}

		

}
