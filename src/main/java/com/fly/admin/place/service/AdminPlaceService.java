package com.fly.admin.place.service;

import java.util.List;

import com.fly.member.place.vo.PlaceVO;

public interface AdminPlaceService {

	// 구장 리스트 출력
	public List<PlaceVO> adminPlaceList(int status, String name);
	
	// 구장 상세 정보 출력
	public PlaceVO adminPlaceDetail(String num);
	
	// 폐업으로 변경된 날짜 출력
	public String getCloseDate(String p_num);
	
	// 구장 승인 상태 변경
	public void updatePok(PlaceVO pvo);
	
}
