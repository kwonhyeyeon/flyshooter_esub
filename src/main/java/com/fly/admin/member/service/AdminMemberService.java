package com.fly.admin.member.service;

import java.util.List;

import com.fly.member.join.vo.MemberVO;

public interface AdminMemberService {
	
	// 회원 정보 list
	public List<MemberVO> getMemberList(String status, String name);
}
