package com.fly.client.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.client.place.dao.PlaceDao;
import com.fly.member.rental.vo.RentalVO;

@Service
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	private PlaceDao placeDao;

	// 구장별 대관 예약 현황
	@Override
	public List<RentalVO> placeRentalList(String p_name) {
		return placeDao.placeRentalList(p_name);
	}

}
