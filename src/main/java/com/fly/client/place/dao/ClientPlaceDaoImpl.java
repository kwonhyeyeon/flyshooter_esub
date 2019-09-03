package com.fly.client.place.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fly.member.stadium.vo.StadiumVO;

@Repository
public class ClientPlaceDaoImpl implements ClientPlaceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "com.fly.client.place.dao.ClientPlaceDao";

	// 구장별 경기장 리스트
	@Override
	public List<StadiumVO> stadiumList(String p_name) {
		return sqlSession.selectList(NAME_SPACE + ".stadiumList", p_name);
	}

}
