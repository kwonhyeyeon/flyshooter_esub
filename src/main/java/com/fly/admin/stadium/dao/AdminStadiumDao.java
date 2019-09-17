package com.fly.admin.stadium.dao;

import java.util.List;

import com.fly.member.stadium.vo.StadiumVO;

public interface AdminStadiumDao {

	// 경기장 리스트 출력
	public List<StadiumVO> getStadiumList(StadiumVO svo);
	
}
