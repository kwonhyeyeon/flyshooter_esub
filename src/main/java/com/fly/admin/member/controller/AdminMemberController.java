package com.fly.admin.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.admin.member.service.AdminMemberService;

@Controller
@RequestMapping(value = "/admin/member")
public class AdminMemberController {
	
	@Resource(name = "adminMemberService")
	private AdminMemberService adminMemberService;

	// 회원 리스트를 보여준다.
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String showMemberListChk(Model model,
			 @RequestParam(value = "status", required = true, defaultValue = "null") String status,
			 @RequestParam(value = "name", required = true, defaultValue = "null") String name) {
		
		model.addAttribute("memberList", adminMemberService.getMemberList(status, name));
		model.addAttribute("status", status);
		model.addAttribute("name", name);
		
		return "admin/member/memberList";
	}
}
