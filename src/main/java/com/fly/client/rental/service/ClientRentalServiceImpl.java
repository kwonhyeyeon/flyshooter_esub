package com.fly.client.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.client.rental.dao.ClientRentalDao;

@Service("clientRentalService")
public class ClientRentalServiceImpl implements ClientRentalService {

	@Autowired
	@Qualifier("clientRentalDao")
	private ClientRentalDao clientRentalDao;
	
}
