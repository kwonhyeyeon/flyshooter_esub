package com.fly.admin.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.admin.member.dao.AdminMemberDao;
import com.fly.member.join.vo.MemberVO;

@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	@Qualifier("adminMemberDao")
	private AdminMemberDao adminMemberDao;

	@Override
	public List<MemberVO> getMemberList(String status, String name) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap();
		map.put("status", status);
		map.put("name", name);
		
		return adminMemberDao.getMemberList(map);
	}
	
	
	
}
