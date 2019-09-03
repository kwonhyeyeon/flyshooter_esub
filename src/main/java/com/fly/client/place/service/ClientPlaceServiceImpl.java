package com.fly.client.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.client.place.dao.ClientPlaceDao;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;

@Service
public class ClientPlaceServiceImpl implements ClientPlaceService {
	
	@Autowired
	private ClientPlaceDao cpDao;

	// 구장별 경기장 리스트
	@Override
	public List<StadiumVO> stadiumList(String p_name) {
		return cpDao.stadiumList(p_name);
	}

}