package com.fly.admin.place.service;

import java.util.List;

import com.fly.member.place.vo.PlaceVO;

public interface AdminPlaceService {

	// 구장 리스트 출력
	public List<PlaceVO> adminPlaceList(PlaceVO pvo);
	
	// 구장 상세 정보 출력
	public PlaceVO adminPlaceDetail(String num);
	
	// 폐업으로 변경된 날짜 출력
	public void getCloseDate(String p_num);
	
	// 구장 승인 상태 변경
	public void updatePok(PlaceVO pvo);
	
	// 리스트 사이즈(paging)
	public int adminPlaceListCnt(PlaceVO pvo);
	
	// 구장 폐업 등록
	public void updateClose(PlaceVO pvo);
	
}
