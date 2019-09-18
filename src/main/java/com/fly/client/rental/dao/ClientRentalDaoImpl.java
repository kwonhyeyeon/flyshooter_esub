package com.fly.client.rental.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("clientRentalDao")
public class ClientRentalDaoImpl implements ClientRentalDao {

	@Autowired
	private SqlSession sqlSession;
	
	private String NAME_SPACE = "com.fly.client.rental.dao.clientRentalDao";
	
}
