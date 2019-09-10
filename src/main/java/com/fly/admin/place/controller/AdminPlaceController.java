package com.fly.admin.place.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;

import com.fly.admin.place.service.AdminPlaceService;
import com.fly.client.place.vo.PlaceVO;

@Controller
@RequestMapping(value = "/admin/place")
public class AdminPlaceController {
	
	@Resource(name = "adminPlaceService")
	private AdminPlaceService adminPlaceService;
	
	// 구장 관리 리스트(구장 상태, 구장명으로 검색)
	@RequestMapping(value = "/placeList.do", method = RequestMethod.GET)
	public String adminPlaceListChk(
			@ModelAttribute PlaceVO pvo,
			Model model,
			@RequestParam(value="status", required = true, defaultValue = "2") int status,
			@RequestParam(value="name", required = true, defaultValue = "null") String name
			) {
		System.out.println("adminPlaceList 호출성공");
		System.out.println(status);
		System.out.println(name);
		
		// 폐업 -2, 임시휴업 -1, 운영전 0, 운영중 1, 전체 2
		// 구장명 검색		
		List<PlaceVO> adminPlaceList = adminPlaceService.adminPlaceList(status, name);
		model.addAttribute("adminPlaceList", adminPlaceList);
		
		model.addAttribute("status", status);
		
		// 미승인 경기장 수
		int stadiumCnt = 0;
		
		try {
			String p_num = adminPlaceList.get(0).getP_num();
			System.out.println(p_num);
			
			stadiumCnt = adminPlaceService.stadiumCnt(p_num);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		model.addAttribute("stadiumCnt", stadiumCnt);
		
		return "admin/place/placeList";
	}
	
	// 구장 정보 상세페이지

}
