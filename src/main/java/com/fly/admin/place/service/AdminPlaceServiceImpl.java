package com.fly.admin.place.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.admin.place.dao.AdminPlaceDao;
import com.fly.member.place.vo.PlaceVO;

@Service("adminPlaceService")
public class AdminPlaceServiceImpl implements AdminPlaceService {
	
	@Autowired
	@Qualifier("adminPlaceDao")
	private AdminPlaceDao adminPlaceDao;

	@Override
	public List<PlaceVO> adminPlaceList(int status, String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("status", status);
	    map.put("name", name);
	      
		return adminPlaceDao.adminPlaceList(map);
	}

	@Override
	public PlaceVO adminPlaceDetail(String num) {
		return adminPlaceDao.adminPlaceDetail(num);
	}

	@Override
	public String getCloseDate(String p_num) {
		return adminPlaceDao.getCloseDate(p_num);
	}

	@Override
	public void updatePok(PlaceVO pvo) {
		adminPlaceDao.updatePok(pvo);;
	}

}
