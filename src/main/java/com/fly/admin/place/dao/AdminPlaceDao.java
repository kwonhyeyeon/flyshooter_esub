package com.fly.admin.place.dao;

import java.util.HashMap;
import java.util.List;

import com.fly.client.place.vo.PlaceVO;

public interface AdminPlaceDao {

	// 구장 리스트
	public List<PlaceVO> adminPlaceList(HashMap<String, Object> map);

	// 미승인 경기장 수
	public int stadiumCnt(String p_num);
	
}
