package com.fly.member.rental.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.client.place.service.PlaceService;
import com.fly.client.place.vo.PlaceVO;

@Controller(value = "/rental")
public class RentalController {
	
	@Autowired
	private PlaceService placeService;
	
	private static final Logger logger = LoggerFactory.getLogger(RentalController.class);
	
	@RequestMapping(value = "/rental/location.do")
	public String suchLocation() {
		return "rental/location";
		}
	
	// 지역으로 검색한 구장리스트
	@RequestMapping(value = "/rental/placeList.do", method = RequestMethod.GET)
	public String suchPlaceList(@ModelAttribute PlaceVO pvo ,Model model, @RequestParam(value = "area", required = true, defaultValue = "null") String area) {
		
		logger.info("============="+area);
		
		List<PlaceVO> suchPlaceList = placeService.suchPlaceList(area);
		
		if(suchPlaceList.isEmpty()) {
			model.addAttribute("message", "[" + area + "]지역에는 등록된 구장이 없습니다.");
			return "rental/location";
		}
		model.addAttribute("suchPlaceList", suchPlaceList);
			for(PlaceVO list : suchPlaceList) {
				logger.info(list.toString());
			}
		return "rental/placeList";
	}
	
	// 대관 신청페이지
	@RequestMapping(value = "/rental/rentalStadium.do", method = RequestMethod.POST)
	public String rentalInsert(@ModelAttribute PlaceVO pvo, Model model) {
		logger.info("여기옴 ?? ==============" + pvo.getP_num());
		logger.info("==============" + pvo.toString());
		model.addAttribute("p_num", pvo.getP_num());
		return "rental/rentalStadium";
	}
	}
