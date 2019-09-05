package com.fly.user.rental.dao;

import java.util.HashMap;
import java.util.List;

public interface UserRentalDao {
	// 해당경기장에서 입력받은 날짜에 예약가능한 시간을 조회한다.
	public List<String> searchReservationTime(HashMap<String, Object> map);
}
