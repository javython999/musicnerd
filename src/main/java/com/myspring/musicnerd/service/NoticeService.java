package com.myspring.musicnerd.service;

import java.util.List;

import com.myspring.musicnerd.vo.ArticleVO;
import com.myspring.musicnerd.vo.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> list() throws Exception;

}
