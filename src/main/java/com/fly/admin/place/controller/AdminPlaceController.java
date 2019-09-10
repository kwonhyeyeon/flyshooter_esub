package com.fly.admin.place.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fly.admin.place.service.AdminPlaceService;

@Controller
@RequestMapping(value = "/admin/place")
public class AdminPlaceController {
	
//	@Resource(name = "adminPlaceService")
//	private AdminPlaceService adminPlaceService;
	
	// 구장 관리 리스트
	@RequestMapping(value = "/placeList.do", method = RequestMethod.GET)
	public String adminPlaceList() {
		System.out.println("adminPlaceList 호출성공");
		return "place/placeList";
	}
	
	// 구장 정보 상세페이지

}
