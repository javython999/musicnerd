package com.myspring.musicnerd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.musicnerd.dao.ArticleDAO;
import com.myspring.musicnerd.service.ArticleService;
import com.myspring.musicnerd.vo.ArticleVO;


@Controller
public class IndexController {
	
	@Inject
	ArticleService articleService;
	
	@Inject
	ArticleDAO articleDAO;
	
	
	// 게시글 목록 조회
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws Exception {
		
		model.addAttribute("list", articleService.list());
		
		return "index";
	}
	
	
	// 게시글 추가
	@RequestMapping("article/insert.do")
	public String insert(@ModelAttribute ArticleVO articleVO) {
		
		// 유튜브 영상 주소에서 영상ID값 구하기
		String str = articleVO.getVideo();
		if(str.length() > 43) { // 플레이리스트에서 영상 가져올시
			String[] array = str.split("&");
			String[] videoID = array[0].split("v=");
			articleVO.setVideo(videoID[1]);
			articleDAO.insert(articleVO);
		} else if (str.length() == 28) { // 공유로 URL가져올시
			String[] array = str.split(".be/");
			articleVO.setVideo(array[1]);
			articleDAO.insert(articleVO);
		} else { // 주소창에서 URL 가져올시
			String[] array = str.split("v=");
			
			// 영상ID값으로 DB에 저장하기
			articleVO.setVideo(array[1]);
			articleDAO.insert(articleVO);
		}
		
		return "redirect:/";
	}
	
	
	// 게시글 조회 (무한스크롤)
	@RequestMapping(value = "article/list", method = RequestMethod.GET)
	@ResponseBody
	public List<ArticleVO> list (@RequestParam("start") int start, @RequestParam("end") int end) throws Exception {
		Map<String, Integer> list = new HashMap<String, Integer>();
		list.put("end", end);
		list.put("start", start);
		return articleService.list(list);
	}
	
	// 게시글 조회 (리프레시)
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	@ResponseBody
	public List<ArticleVO> refresh () throws Exception {
		return articleService.list();
		}
}
