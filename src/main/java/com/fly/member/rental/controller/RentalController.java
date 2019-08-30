package com.fly.member.rental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/rental")
public class RentalController {
	
	private static final Logger logger = LoggerFactory.getLogger(RentalController.class);
	
	@RequestMapping(value = "/rental/location.do")
	public String suchLocation() {
		
		return "rental/location";
	}
}
