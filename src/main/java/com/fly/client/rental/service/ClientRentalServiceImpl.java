package com.fly.client.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.client.rental.dao.ClientRentalDao;
import com.fly.member.place.vo.PlaceVO;

@Service("clientRentalService")
public class ClientRentalServiceImpl implements ClientRentalService {

	@Autowired
	@Qualifier("clientRentalDao")
	private ClientRentalDao clientRentalDao;
	
	
	// 구장 리스트
		@Override
		public List<PlaceVO> placeList(String m_id) {
			
			return clientRentalDao.placeList(m_id);
		}
}
