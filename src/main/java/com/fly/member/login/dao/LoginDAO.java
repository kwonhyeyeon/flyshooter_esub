package com.fly.member.login.dao;

import java.sql.SQLException;

import com.fly.member.login.vo.LoginVO;

public interface LoginDAO {
	public LoginVO userIdSelect(String m_id);
	public LoginVO loginSelect(LoginVO lvo); 
	
	public int loginHistoryInsert(LoginVO lvo) throws SQLException;
	public int loginHistoryUpdate(LoginVO lvo);
	public LoginVO loginHistorySelect(String m_id);
}
