package com.fly.admin.place.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fly.admin.place.service.AdminPlaceService;
import com.fly.member.place.vo.PlaceVO;

@Controller
@RequestMapping(value = "/admin/place")
public class AdminPlaceController {
	
	@Resource(name = "adminPlaceService")
	private AdminPlaceService adminPlaceService;
	
	// 구장 관리 리스트(구장 상태, 구장명으로 검색)
	@RequestMapping(value = "/placeList.do", method = RequestMethod.GET)
	public String adminPlaceListChk(
			HttpServletRequest request,
			@ModelAttribute PlaceVO pvo,
			Model model,
			@RequestParam(value="status", required = true, defaultValue = "2") int status,
			@RequestParam(value="name", required = true, defaultValue = "null") String name
			) {
		System.out.println("adminPlaceList 호출 성공");
		
		// 폐업 -2, 임시휴업 -1, 운영전 0, 운영중 1, 전체 2
		// 구장명 검색		
		List<PlaceVO> adminPlaceList = adminPlaceService.adminPlaceList(status, name);
		model.addAttribute("adminPlaceList", adminPlaceService.adminPlaceList(status, name));
		model.addAttribute("status", status);
		model.addAttribute("name", name);
		return "admin/place/placeList";
	}
	
	// 구장 정보 상세페이지
	@RequestMapping(value = "/placeDetail.do", method = RequestMethod.GET)
	public String adminPlaceDetailChk(
			HttpServletRequest request,
			@ModelAttribute PlaceVO pvo,
			Model model,
			@RequestParam(value="num", required = true, defaultValue = "null") String num
			) {
		
		System.out.println("adminPlaceDetailChk 호출 성공");
		System.out.println(num);
		
		int status = pvo.getP_status();
		String p_num = pvo.getP_num();
		// 폐업 등록일 출력
		if(status == -2) {
			try {
				pvo = adminPlaceService.adminPlaceDetail(num);
				model.addAttribute("pvo", pvo);
				
				String closeDate = adminPlaceService.getCloseDate(p_num);
				model.addAttribute("closeDate", closeDate);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			pvo = adminPlaceService.adminPlaceDetail(num);
			model.addAttribute("pvo", pvo);
		}
		
		//System.out.println(pvo.toString());
		
		return "admin/place/placeDetail";
	}
	
	// 구장 승인 상태 변경
	@RequestMapping(value = "/updatePok.do", method = RequestMethod.POST)
	public String updatePokChk(HttpServletRequest request, @ModelAttribute PlaceVO pvo, RedirectAttributes redirectAttr) {
		
		System.out.println("updatePokChk 호출 성공");
		
		adminPlaceService.updatePok(pvo);
		System.out.println(pvo.getP_num()+123);
		System.out.println(pvo.getP_ok()+123);
		
		redirectAttr.addAttribute("num", pvo.getP_num());
		
		return "redirect:/admin/place/placeDetail.do";
		
	}

}
