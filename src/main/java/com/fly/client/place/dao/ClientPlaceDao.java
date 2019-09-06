package com.fly.client.place.dao;

import java.util.List;

import com.fly.client.place.vo.PlaceVO;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;

public interface ClientPlaceDao {
	
	// 구장 리스트
	public List<PlaceVO> placeList(String m_id);
	// 경기장 리스트
	public List<StadiumVO> stadiumList(String p_num);
	// 대관 예약 리스트
	public List<RentalVO> rentalList(int s_no);
	
}
