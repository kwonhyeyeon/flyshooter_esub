package com.fly.user.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.member.place.vo.PlaceVO;
import com.fly.user.place.dao.PlaceDao;


@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceDao placeDao;
	
	@Override
	public List<PlaceVO> searchPlaceList(String area) {
		// TODO Auto-generated method stub
		return placeDao.searchPlaceList(area);
	}

	@Override
	public PlaceVO selectPlace(String p_num) {
		// TODO Auto-generated method stub
		return placeDao.selectPlace(p_num);
	}

}
