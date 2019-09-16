package com.fly.admin.place.dao;

import java.util.HashMap;
import java.util.List;

import com.fly.member.place.vo.PlaceVO;

public interface AdminPlaceDao {

	// 구장 리스트
	public List<PlaceVO> adminPlaceList(HashMap<String, Object> map);
	
	// 구장 상세 정보
	public PlaceVO adminPlaceDetail(String num);
	
	// 폐업으로 변경된 날짜 출력
	public String getCloseDate(String p_num);
	
	// 구장 승인 상태 변경
	public void updatePok(PlaceVO pvo);
	
}
