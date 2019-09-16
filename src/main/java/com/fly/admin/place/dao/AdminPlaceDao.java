package com.fly.admin.place.dao;

import java.util.HashMap;
import java.util.List;

import com.fly.member.place.vo.PlaceVO;

public interface AdminPlaceDao {

	// 구장 리스트
	public List<PlaceVO> adminPlaceList(HashMap<String, Object> map);
	
	// 구장 상세 정보
	public PlaceVO adminPlaceDetail(String num);
	
}
