package com.fly.admin.login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.admin.login.service.AdminLoginService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Resource(name = "adminLoginService")
	private AdminLoginService adminLoginService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// 실행시 adminlogin.jsp로 연결시켜주는 맵핑 (test를 위하여 만듬)
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String adminlogin(HttpSession session, HttpServletRequest request) {
		
		
		return "admin/login";
	}

	// 로그인버튼 클릭시 ID검사및 세션값 저장을 담당
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String adminlogin(HttpSession session, HttpServletRequest request, @RequestParam(value = "adminId") String adminId,
			@RequestParam(value = "adminPw") String adminPw) {
		
		boolean loginPass;
		
		loginPass = loginCheck(adminId, adminPw);
		if (loginPass) {
			session.setAttribute("adminId", adminId);
			
			return "admin/main";
		}

		return "admin/login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session, HttpServletRequest request){
		session.invalidate();
		session = request.getSession(true);
		return "admin/login";
	}
	
	private boolean loginCheck(String adminId, String adminPw) {
		// TODO Auto-generated method stub
		boolean loginPass = false;
		if ("admin".equals(adminId) && "admin1234".equals(adminPw)) {
			loginPass = true;
		}
		return loginPass;
	}
	
	// 로그인 시 이동 페이지, 메인화면 누적 통계
	@RequestMapping(value = "/main.do", method = {RequestMethod.POST})
	public String main(HttpSession session, HttpServletRequest request, 
			@RequestParam(value = "adminId") String adminId,
			@RequestParam(value = "adminPw") String adminPw,
			Model model) {
		
		// 회원가입 수
		int registDayCnt = adminLoginService.registCnt("일");
		int registMonthCnt = adminLoginService.registCnt("월");
		int registTotalCnt = adminLoginService.registCnt("");
		
		model.addAttribute("registDayCnt", registDayCnt);
		model.addAttribute("registMonthCnt", registMonthCnt);
		model.addAttribute("registTotalCnt", registTotalCnt);
		
		// 구장 등록 수
		int placeDayCnt = adminLoginService.placeCnt("일");
		int placeMonthCnt = adminLoginService.placeCnt("월");
		int placeTotalCnt = adminLoginService.placeCnt("");
		
		model.addAttribute("placeDayCnt", placeDayCnt);
		model.addAttribute("placeMonthCnt", placeMonthCnt);
		model.addAttribute("placeTotalCnt", placeTotalCnt);
		
		// 경기장 예약 수
		int rentalDayCnt = adminLoginService.rentalCnt("일");
		int rentalMonthCnt = adminLoginService.rentalCnt("월");
		int rentalTotalCnt = adminLoginService.rentalCnt("");
		
		model.addAttribute("rentalDayCnt", rentalDayCnt);
		model.addAttribute("rentalMonthCnt", rentalMonthCnt);
		model.addAttribute("rentalTotalCnt", rentalTotalCnt);
		
		// 매치 게시판 등록 수
		int matchDayCnt = adminLoginService.matchCnt("일");
		int matchMonthCnt = adminLoginService.matchCnt("월");
		int matchTotalCnt = adminLoginService.matchCnt("");
		
		model.addAttribute("matchDayCnt", matchDayCnt);
		model.addAttribute("matchMonthCnt", matchMonthCnt);
		model.addAttribute("matchTotalCnt", matchTotalCnt);

		return "admin/main";
	}

}
