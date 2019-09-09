package com.fly.admin.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/member")
public class AdminMemberController {

	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String showMemberList() {
		System.out.println("showMemberList 호출성공");
		return "admin/member/memberList";
	}
}
