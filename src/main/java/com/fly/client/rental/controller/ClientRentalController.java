package com.fly.client.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fly.client.place.service.ClientPlaceService;
import com.fly.member.rental.vo.RentalVO;

@Controller(value="/client/rental")
public class ClientRentalController {
	
	@Autowired
	private ClientPlaceService placeService;
	
	@RequestMapping(value="/rental/rentalList.do")
	public String stadiumList(Model model) {
		model.addAttribute("m_id", "aaa@naver.com");
	     model.addAttribute("m_type", 0);
	      
		return "rental/rentalList";
	}

}
