package com.fly.admin.stadium.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fly.admin.stadium.service.AdminStadiumService;
import com.fly.member.stadium.vo.StadiumVO;

@Controller
@RequestMapping(value = "/admin/stadium")
public class AdminStadiumController {

	@Resource(name = "adminStadiumService")
	private AdminStadiumService adminStadiumService;
	
	// 경기장 상세 정보
	@RequestMapping(value = "/stadiumDetail.do", method = RequestMethod.GET)
	public String getStadiumDetailChk(
			HttpServletRequest request,
			Model model,
			@ModelAttribute StadiumVO svo
			) {
		System.out.println("getStadiumDetailChk 호출 성공");
		
		int s_no = svo.getS_no();
		svo = adminStadiumService.getStadiumDetail(s_no);
		model.addAttribute("svo", svo);
		
		return "/admin/place/stadiumDetail";
	}
	
}
