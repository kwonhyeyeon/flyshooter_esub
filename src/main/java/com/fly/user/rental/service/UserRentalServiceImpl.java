package com.fly.user.rental.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.user.rental.dao.UserRentalDao;

@Service("userRentalService")
public class UserRentalServiceImpl implements UserRentalService {

	@Autowired
	@Qualifier("userRentalDao")
	private UserRentalDao userRentalDao;
	
	@Override
	public List<String> searchReservationTime(String selectDay, int s_no) {
		// TODO Auto-generated method stub
		
		// 두개의 parammeter 넘기기 위해 HashMap 사용.
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("selectDay", selectDay);
		map.put("s_no", s_no);
		
		return userRentalDao.searchReservationTime(map);
	}

	@Override
	public int reservationCheck(String overlapKey) {
		// TODO Auto-generated method stub
		
		
		long time = System.currentTimeMillis(); 
		long minutes = (time / (1000*60)); // 현재시간을 분으로 변환
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("overlapKey", overlapKey);
		map.put("minutes", minutes);
		
		
		return userRentalDao.reservationCheck(map);
	}

	@Override
	public int deleteReservation(String overlap) {
		// TODO Auto-generated method stub
		
		long time = System.currentTimeMillis(); 
		long minutes = (time / (1000*60));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("overlap", overlap);
		map.put("minutes", minutes);
	
		return userRentalDao.deleteReservation(map);
	}

}
