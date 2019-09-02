package com.fly.common.login.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fly.common.login.vo.LoginVO;

//@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SqlSession session;
	
	@Override
	public LoginVO userIdSelect(String m_id) {
		
		return (LoginVO)session.selectOne("userIdSelect", m_id);
	}

	@Override
	public LoginVO loginSelect(LoginVO lvo) {
		return (LoginVO)session.selectOne("loginSelect", lvo);
	}

	@Override
	public int loginHistoryInsert(LoginVO lvo) throws SQLException {
		return session.insert("loginHistoryInsert", lvo);
		
	}

	@Override
	public int loginHistoryUpdate(LoginVO lvo) {
		return session.update("loginHistoryUpdate", lvo);
	}

	@Override
	public LoginVO loginHistorySelect(String m_id) {
		return session.selectOne("loginHistorySelect", m_id);
		
	}

}
