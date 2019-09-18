package com.fly.client.place.service;

import java.util.List;

import com.fly.member.place.vo.PlaceVO;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;

public interface ClientPlaceService {
	
	// 경기장 리스트 - 메소드 변경 해야함
	public List<StadiumVO> stadiumList(String p_num);

	// 대관 예약 리스트
	public List<RentalVO> rentalList(int s_no, String r_reserve_date);
	
}
