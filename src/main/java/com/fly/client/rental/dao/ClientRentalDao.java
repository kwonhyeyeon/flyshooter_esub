package com.fly.client.rental.dao;

import java.util.List;

import com.fly.member.place.vo.PlaceVO;

public interface ClientRentalDao {
	
	// 구장 리스트
	public List<PlaceVO> placeList(String m_id);

}
