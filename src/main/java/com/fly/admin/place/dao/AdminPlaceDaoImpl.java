package com.fly.admin.place.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fly.member.place.vo.PlaceVO;

@Repository("adminPlaceDao")
public class AdminPlaceDaoImpl implements AdminPlaceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String NAME_SPACE = "com.fly.admin.place.dao.AdminPlaceDao";

	@Override
	public List<PlaceVO> adminPlaceList(HashMap<String, Object> map) {
		return sqlSession.selectList(NAME_SPACE + ".adminPlaceList", map);
	}

	@Override
	public PlaceVO adminPlaceDetail(String num) {
		return (PlaceVO)sqlSession.selectOne(NAME_SPACE + ".adminPlaceDetail", num);
	}

}
