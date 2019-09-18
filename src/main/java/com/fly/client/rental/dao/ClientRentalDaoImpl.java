package com.fly.client.rental.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fly.member.place.vo.PlaceVO;

@Repository("clientRentalDao")
public class ClientRentalDaoImpl implements ClientRentalDao {

	@Autowired
	private SqlSession sqlSession;
	
	private String NAME_SPACE = "com.fly.client.rental.dao.clientRentalDao";
	
	// 구장 리스트
		@Override
		public List<PlaceVO> placeList(String m_id) {
			return sqlSession.selectList("placeList", m_id);
		}
	
}
