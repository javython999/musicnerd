package com.myspring.musicnerd.dao;

import java.util.List;

import com.myspring.musicnerd.vo.NoticeVO;

public interface NoticeDAO {

	public List<NoticeVO> list() throws Exception;
	public void insert(NoticeVO noticeVO);
}
