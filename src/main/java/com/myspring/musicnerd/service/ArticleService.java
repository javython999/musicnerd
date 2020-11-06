package com.myspring.musicnerd.service;

import java.util.List;
import java.util.Map;

import com.myspring.musicnerd.vo.ArticleVO;



public interface ArticleService {
	
	public List<ArticleVO> list() throws Exception;
	List<ArticleVO> list(Map<String, Integer> list) throws Exception;
	
}
