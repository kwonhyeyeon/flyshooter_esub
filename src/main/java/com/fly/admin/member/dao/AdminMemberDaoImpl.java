package com.fly.admin.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fly.member.join.vo.MemberVO;
@Repository("adminMemberDao")
public class AdminMemberDaoImpl implements AdminMemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	private String NAME_SPACE = "com.fly.admin.member.dao.AdminMemberDao";
	
	@Override
	public List<MemberVO> getMemberList(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAME_SPACE + ".memberList", map);
	}

}
