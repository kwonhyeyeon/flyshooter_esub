package com.fly.admin.place.service;

import java.util.List;

import com.fly.client.place.vo.PlaceVO;

public interface AdminPlaceService {

	// 구장 리스트 출력
	public List<PlaceVO> adminPlaceList(int status, String name);

	// 미승인 경기장 수 출력
	public int stadiumCnt(String p_num);
	
}
