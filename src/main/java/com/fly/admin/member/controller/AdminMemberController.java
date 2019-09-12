package com.fly.admin.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.admin.member.service.AdminMemberService;
import com.fly.member.join.vo.MemberVO;

@Controller
@RequestMapping(value = "/admin/member")
public class AdminMemberController {
	
	@Resource(name = "adminMemberService")
	private AdminMemberService adminMemberService;

	// 회원 리스트를 보여준다.
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String showMemberListChk(Model model, HttpServletRequest request,
			 @RequestParam(value = "status", required = true, defaultValue = "null") String status,
			 @RequestParam(value = "such_m_name", required = true, defaultValue = "null") String name) {
		model.addAttribute("memberList", adminMemberService.getMemberList(status, name));
		model.addAttribute("status", status);
		
		return "admin/member/memberList";
	}
	
	
	  @RequestMapping(value = "/memberUpdate.do", method = RequestMethod.POST)
	  public String memberUpdateChk(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		  
		  if(mvo.getM_type() == 1) {
			  // 일반회원
		  }else if(mvo.getM_type() == 0) {
			  // 사업자
		  }else {
			  // 오류
		  }
		  
		  return "redirect:/admin/member/memberList.do";
	  }
	 
}
