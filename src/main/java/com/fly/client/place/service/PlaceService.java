package com.fly.client.place.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fly.client.place.dao.PlaceDao;
import com.fly.client.place.vo.PlaceVO;

public interface PlaceService {

	
	// 지역으로 검색한 구장리스트
	public List<PlaceVO> searchPlaceList(String area);
	
}
