package com.fly.client.place.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.client.place.dao.ClientPlaceDao;
import com.fly.member.place.vo.PlaceVO;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;

@Service("clientPlaceService")
public class ClientPlaceServiceImpl implements ClientPlaceService {
	
	@Autowired
	@Qualifier("clientPlaceDao")
	private ClientPlaceDao clientPlaceDao;
	
	

	
}
