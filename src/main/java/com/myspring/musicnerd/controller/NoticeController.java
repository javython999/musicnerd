package com.myspring.musicnerd.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.musicnerd.dao.NoticeDAO;
import com.myspring.musicnerd.dao.NoticeDAO;
import com.myspring.musicnerd.service.NoticeService;
import com.myspring.musicnerd.vo.ArticleVO;
import com.myspring.musicnerd.vo.NoticeVO;

@Controller
public class NoticeController {

	@Inject
	NoticeService noticeService;
	
	@Inject
	NoticeDAO noticeDAO;
	
	// 공지글 조회 (리프레시)
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	@ResponseBody
	public List<NoticeVO> refresh () throws Exception {
		return noticeService.list();
	}
	
	
	// 게시글 추가
	@RequestMapping("notice/insert.do")
	public String insert(@ModelAttribute NoticeVO noticeVO) {
			
			noticeDAO.insert(noticeVO);
			return "redirect:/";
		}

}
