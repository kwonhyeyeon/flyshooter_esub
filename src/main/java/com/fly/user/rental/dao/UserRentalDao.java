package com.fly.user.rental.dao;

import java.util.HashMap;
import java.util.List;

import com.fly.member.rental.vo.RentalVO;

public interface UserRentalDao {
	// 해당경기장에서 입력받은 날짜에 예약가능한 시간을 조회한다.
	public List<String> searchReservationTime(HashMap<String, Object> map);
	
	// 선택한 시간이 예약중인지 조회한다.
	public int reservationCheck(HashMap<String, Object> map);
	
	// 예약중 테이블에 등록후 5분이 지나면 삭제한다.
	public int deleteReservation(HashMap<String, Object> map);
	
	// 대관 데이터 insert
	public int insertRental(RentalVO rvo);
}