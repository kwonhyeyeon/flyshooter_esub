package com.fly.client.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.client.place.dao.PlaceDao;
import com.fly.client.place.vo.PlaceVO;


@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceDao placeDao;
	
	@Override
	public List<PlaceVO> suchPlaceList(String area) {
		// TODO Auto-generated method stub
		return placeDao.suchPlaceList(area);
	}

}
