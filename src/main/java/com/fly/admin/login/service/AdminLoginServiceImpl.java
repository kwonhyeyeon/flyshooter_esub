package com.fly.admin.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.admin.login.dao.AdminLoginDao;

@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	@Qualifier("adminLoginDao")
	private AdminLoginDao adminLoginDao;

	@Override
	public int registCnt(String date) {
		return adminLoginDao.registCnt(date);
	}

	@Override
	public int placeCnt(String date) {
		return adminLoginDao.placeCnt(date);
	}

	@Override
	public int rentalCnt(String date) {
		return adminLoginDao.rentalCnt(date);
	}

	@Override
	public int matchCnt(String date) {
		return adminLoginDao.matchCnt(date);
	}

	@Override
	public int supportCnt(String date) {
		return adminLoginDao.supportCnt(date);
	}

}
