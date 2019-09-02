package com.fly.user.stadium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.member.stadium.vo.StadiumVO;
import com.fly.user.stadium.dao.StadiumDao;

@Service
public class StadiumServiceImpl implements StadiumService {

	@Autowired
	private StadiumDao stadiumDao;
	
	@Override
	public List<StadiumVO> selectStadiumList(String p_num) {
		// TODO Auto-generated method stub
		return stadiumDao.selectStadiumList(p_num);
	}

}
