package com.fly.client.place.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fly.member.place.vo.PlaceVO;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;

@Repository("clientPlaceDao")
public class ClientPlaceDaoImpl implements ClientPlaceDao {
	
	@Autowired
	private SqlSession session;
	
	private String NAME_SPACE = "com.fly.client.place.dao.ClientPlaceDao";

	

}
