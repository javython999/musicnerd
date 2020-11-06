package com.myspring.musicnerd.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myspring.musicnerd.dao.NoticeDAO;
import com.myspring.musicnerd.vo.NoticeVO;

@Service
public class NoticeServiceImp implements NoticeService {

	@Inject
	NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return noticeDAO.list();
	}

}
