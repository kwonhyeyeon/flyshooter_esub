package com.fly.member.login.service;

import java.sql.SQLException;

import com.fly.member.login.vo.LoginVO;

public interface LoginService {
	public LoginVO userIdSelect(String m_id);
	public LoginVO loginSelect(String m_id, String m_pw);
	
	public int loginHistoryInsert(LoginVO lvo) throws SQLException;
	public int loginHistoryUpdate(LoginVO lvo);
	public LoginVO loginHistorySelect(String m_id);
}
