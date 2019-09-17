package com.fly.admin.stadium.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fly.admin.stadium.service.AdminStadiumService;

@Controller
@RequestMapping(value = "/admin/stadium")
public class AdminStadiumController {

	@Resource(name = "adminStadiumService")
	private AdminStadiumService adminStadiumService;
	
	// 경기장 상세 정보
	@RequestMapping(value = "/stadiumDetail.do", method = RequestMethod.POST)
	public String getStadiumDetailChk() {
		System.out.println("getStadiumDetailChk 호출 성공");
		
		return "/admin/place/stadiumDetail";
	}
	
}
