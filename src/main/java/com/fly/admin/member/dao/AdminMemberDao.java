package com.fly.admin.member.dao;

import java.util.HashMap;
import java.util.List;

import com.fly.member.join.vo.MemberVO;

public interface AdminMemberDao {

	// 회원 정보 list
	public List<MemberVO> getMemberList(HashMap<String, String> map);
}
