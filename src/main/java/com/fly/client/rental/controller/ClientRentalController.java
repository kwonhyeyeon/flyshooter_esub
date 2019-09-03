package com.fly.client.rental.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly.client.place.service.ClientPlaceService;
import com.fly.member.itemsrental.vo.ItemsRentalVO;
import com.fly.member.place.vo.PlaceVO;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;

@Controller
@RequestMapping(value = "/client/rental")
public class ClientRentalController {

	@Resource(name = "clientPlaceService")
	private ClientPlaceService clientPlaceService;
	
	// 구장 별 경기장 별 대관 예약 현황
	@RequestMapping(value = "/rentalList.do", method = RequestMethod.GET)
	public String rentalListByStadiumByPlace(
			Model model,
			@ModelAttribute ItemsRentalVO irvo,
			@ModelAttribute RentalVO rvo,
			@ModelAttribute StadiumVO svo,
			@RequestParam(value = "m_id", required = true, defaultValue = "aaa@naver.com") String m_id,
			@RequestParam(value = "p_num", required = true, defaultValue = "null") String p_num) {
		
		System.out.println("구장 별 경기장 별 대관 예약 현황 호출");
		
		// 임시
		model.addAttribute("m_id", "aaa@naver.com");
		model.addAttribute("m_type", 0);
		
		model.addAttribute("irvo", irvo);
		model.addAttribute("rvo", rvo);
		model.addAttribute("svo", svo);
		
		// 구장 리스트 출력
		List<PlaceVO> placeList = clientPlaceService.placeList(m_id);
		
		model.addAttribute("placeList", placeList);
	    for(PlaceVO place : placeList) {
	    	System.out.println("구장 리스트");
	    	System.out.println(place.toString());
	    }
	    
		// 경기장 리스트 출력
		if(p_num.equals("null")) { // 배열의 첫번째 값
			
			List<StadiumVO> stadiumList = clientPlaceService.stadiumList(p_num); // null 값
			
			model.addAttribute("stadiumList", stadiumList);
			for(StadiumVO stadium : stadiumList) {
				System.out.println("경기장 리스트");
				System.out.println(stadium.getP_num());
				System.out.println(stadium.getS_name());
		    	System.out.println(stadium.toString());
		    }
			
		} else { // 선택한 구장의 값
			List<StadiumVO> stadiumList = clientPlaceService.stadiumList(p_num);
			
			System.out.println(stadiumList);
		}
		
		// 대관 리스트 출력		
//		List<RentalVO> rentalList = clientPlaceService.rentalList(s_no);
//		model.addAttribute("rentalList", rentalList);

		return "rental/rentalList";
	}

}
