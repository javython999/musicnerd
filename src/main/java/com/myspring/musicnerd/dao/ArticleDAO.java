package com.myspring.musicnerd.dao;

import java.util.List;
import java.util.Map;

import com.myspring.musicnerd.vo.ArticleVO;

public interface ArticleDAO {
	public void insert(ArticleVO articleVO);
	public List<ArticleVO> list() throws Exception;
	public List<ArticleVO> list(Map<String, Integer> list) throws Exception;
}
