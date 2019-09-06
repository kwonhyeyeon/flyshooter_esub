package com.fly.user.rental.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("userRentalDao")
public class UserRentalDaoImpl implements UserRentalDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "com.fly.user.rental.dao.UserRentalDAO";
	
	@Override
	public List<String> searchReservationTime(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAME_SPACE + ".searchReservationTime", map);
	}

	@Override
	public int reservationCheck(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAME_SPACE + ".reservationCheck", map);
	}

	@Override
	public int deleteReservation(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAME_SPACE + ".deleteReservation", map);
	}

}


