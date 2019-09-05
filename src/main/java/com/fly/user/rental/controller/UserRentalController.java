package com.fly.user.rental.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fly.member.place.vo.PlaceVO;
import com.fly.member.stadium.vo.StadiumVO;
import com.fly.user.place.service.UserPlaceService;
import com.fly.user.rental.service.UserRentalService;
import com.fly.user.stadium.service.UserStadiumService;

@Controller
@RequestMapping(value = "/user/rental")
public class UserRentalController {
	
	@Resource(name="userPlaceService")
    private UserPlaceService placeService;
	@Resource(name = "userStadiumService")
	private UserStadiumService userStadiumService;
	@Resource(name = "userRentalService")
	private UserRentalService userRentalService;
   
	private static final Logger log = LoggerFactory.getLogger(UserRentalController.class);   
   
    @RequestMapping(value = "/location.do")
    public String searchLocation(Model model) {
	    
       return "rental/location";
    }
   
   // 지역으로 검색한 구장리스트
   @RequestMapping(value = "/placeList.do", method = RequestMethod.GET)
   public String searchPlaceList(@ModelAttribute PlaceVO pvo, Model model, RedirectAttributes redirectAttr, @RequestParam(value = "area", required = true, defaultValue = "null") String area) {
      
	   log.info("============="+area);
      
      List<PlaceVO> searchPlaceList = placeService.searchPlaceList(area);
      if(searchPlaceList.isEmpty()) {
         redirectAttr.addFlashAttribute("message", "[" + area + "]지역에는 등록된 구장이 없습니다.");
         return "redirect:/user/rental/location.do";
      }
      model.addAttribute("searchPlaceList", searchPlaceList);
         for(PlaceVO list : searchPlaceList) {
        	 log.info(list.toString());
         }
      return "rental/placeList";
   }
   
   // 대관 신청페이지
   @RequestMapping(value = "/rentalStadium.do", method = RequestMethod.POST)
   public String rentalInfo(@ModelAttribute PlaceVO pvo,
		   @ModelAttribute StadiumVO svo, Model model, @RequestParam(value = "p_num") String p_num, @RequestParam(value = "area", required = true, defaultValue = "null") String area, RedirectAttributes redirectAttr) {

      pvo = placeService.selectPlace(p_num);
      List<StadiumVO> stadiumList = userStadiumService.selectStadiumList(p_num);
      
      // log
      System.out.println(pvo.toString());
      for(StadiumVO svo2 : stadiumList) {
    	  System.out.println(svo2.toString());
      }
      System.out.println(stadiumList.size());
      // end 
      
      model.addAttribute("pvo", pvo);
      model.addAttribute("stadiumList", stadiumList);
      
      
      return "rental/rentalStadium";
   }
   
   // 대관일, 경기장일련번호로 예약가능한 시간을 비동기로 조회하는 메소드
   @RequestMapping(value = "/searchTime.do", method = RequestMethod.POST, produces= "text/html; charset=UTF-8")
   @ResponseBody
   public String searchTime(@ModelAttribute StadiumVO svo,
		   @RequestParam(value = "selectDay") String selectDay){
	   
	   String result = "";
	   
	  List<String> impossibleTime = userRentalService.searchReservationTime(selectDay, svo.getS_no());
	  
	  System.out.println("증가========"+svo.getS_hours());
	  System.out.println(svo.getS_no());
	  System.out.println("마감========"+svo.getP_close());
	  System.out.println("시작========"+svo.getP_open());
	  int start = Integer.parseInt(svo.getP_open());
	  int end = Integer.parseInt(svo.getP_close());
	  int increase = svo.getS_hours();
	  impossibleTime.add("10");
	  impossibleTime.add("15");
	  impossibleTime.add("18");
	  impossibleTime.add("19");
	  
		/*
		 * for(int i = start; i+increase <= end; i+=increase) { result +=
		 * "<article class='stadiumRentalTime' value='"+i+","+(i+increase)+"'";
		 * if(impossibleTime.contains(i+"")) { result += " style='display:none' "; }
		 * result += "><p>"+i+" ~ "+ (i + increase) + "(시)</p></article>"; }
		 */
	   
	  for(int i = start; i+increase <= end; i+=increase) {
		  result += "<label><input type='radio' name='reservationTime' value='"+i+","+(i+increase)+"'";
		 
			  if(impossibleTime.contains(i+"")) {
				  result += " style='display:none' /></label>";
			  }else {
			  result += "/>"+i+" ~ "+ (i + increase) + "(시)</label>";
		  }
	  }
	  
	  
	   return result;
   }
   
   }

