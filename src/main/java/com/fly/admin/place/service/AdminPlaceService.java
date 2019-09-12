package com.fly.admin.place.service;

import java.util.List;

import com.fly.client.place.vo.PlaceVO;

public interface AdminPlaceService {

	// 구장 리스트 출력
	public List<PlaceVO> adminPlaceList(int status, String name);
	
	// 구장 상세 정보 출력
	public PlaceVO adminPlaceDetail(String num);
	
}
