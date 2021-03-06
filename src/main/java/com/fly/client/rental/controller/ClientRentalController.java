package com.fly.client.rental.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.client.rental.service.ClientRentalService;
import com.fly.member.itemsrental.service.ItemsRentalService;
import com.fly.member.itemsrental.vo.ItemsRentalVO;
import com.fly.member.join.vo.MemberVO;
import com.fly.member.place.vo.PlaceVO;
import com.fly.member.rental.vo.RentalVO;
import com.fly.member.stadium.vo.StadiumVO;
import com.fly.paging.util.Paging;
import com.fly.paging.util.Util;

@Controller
@RequestMapping(value = "/client/rental")
public class ClientRentalController {

	@Resource(name = "clientRentalService")
	private ClientRentalService clientRentalService;
	@Resource(name = "itemsRentalService")
	private ItemsRentalService ItemsRentalService;
	
	// 구장 별 경기장 별 대관 예약 현황(첫 로드)
	@RequestMapping(value = "/rentalList.do", method = RequestMethod.GET)
	public String rentalListByStadiumByPlace(Model model) {
		/*
		 * Session에서 회원 ID를 뺴와서 사용해야함 수정하시오.
		 */
		String m_id = "esub17@naver.com";
		
		model.addAttribute("placeList", clientRentalService.getPlaceList(m_id));
		
		
		
		return "/rental/rentalList";
	}
	
	
	@RequestMapping(value = "/getList.do", method = RequestMethod.POST,  produces= "text/html; charset=UTF-8")
	@ResponseBody
	public String setList(@RequestParam(value = "p_num") String p_num, 
			@RequestParam(value = "selectDay") String selectDay) {
		
		int r_end = 0;
		StringBuffer result = new StringBuffer();
		List<StadiumVO> stadiumList = clientRentalService.getStadiumList(p_num);
		List<RentalVO> rentalList = null;
		
		if( stadiumList.isEmpty() ) {
			result.append("<p class='noStadium'>등록된 경기장이 없습니다.</p>"); 
			return result.toString();
		}
	
		result.append("<h1 style='color:red'> ※ 온라인 대관일경우 환불요청  / 오프라인 대관일경우 대관취소 기능만 이용하실수 있습니다.</h1>");
		for( StadiumVO svo : stadiumList ) {
			
			result.append("<p class='stadiumName'>");
			result.append(svo.getS_name());
			result.append("</p>");
			result.append("<hr /><br />");
			rentalList = clientRentalService.getRentalList(svo.getS_no(), selectDay);
			result.append("<div class='rentalListArea'>");
			if( rentalList.isEmpty() ) {
				result.append("<p class='noStadium'>대관 이력이 없습니다.</p>");
			}else {
				result.append("<table class='rentalListTbl'>");
				result.append("<tr><td>예약자명</td><td>전화번호</td><td>예약시간</td><td>용품대여</td><td>대관유형</td><td>환불/취소</td></tr>");
					for( RentalVO rvo : rentalList ) {
						result.append("<tr class='rental' data-num='");
						result.append(rvo.getR_no());
						result.append(",");
						result.append(rvo.getR_regdate());
						result.append(",");
						result.append(rvo.getR_total_pay());
						result.append("'>");
						result.append("<td>");
						result.append(rvo.getR_bank());
						result.append("</td>");
						result.append("<td>");
						result.append(rvo.getR_account());
						result.append("</td>");
						result.append("<td>");
						result.append(selectDay);
						result.append(" (");
						result.append(rvo.getR_start());
						result.append("-");
						
						// 종료시간 계산
						r_end = Integer.parseInt( rvo.getR_start() ) + rvo.getCal_status();

						result.append(r_end);
						result.append(")시");
						result.append("</td>");
						if( rvo.getRefund() > 0 ) {
							switch( rvo.getR_pay_type() ) {
							case 1:
								result.append("<td style='color:red'>(미반납)");
								break;
							case 2:
								result.append("<td style='color:blue'>(반납완료)");
								break;
							default:
								result.append("<td>유");
							}
							
						}else {
							result.append("<td>무");
						}
						result.append("</td>");
						
						result.append("<td>");
						if( rvo.getR_pay_status() == 0 ) {
							result.append("오프라인");
							result.append("</td>");
							result.append("<td><button class='r_cancle'>대관취소</button></td>");
						}else if( rvo.getR_pay_status() == 1 ) {
							result.append("온라인");
							result.append("</td>");
							result.append("<td><button class='r_refund'>환불요청</button></td>");
						}else {
							result.append("환불대기중");
							result.append("</td>");
							result.append("<td>..</td>");
						}
						
						
						result.append("</tr>");
						
						
					}
				result.append("</table>");
			}
			result.append("</div>");
		}
	
		System.out.println("버퍼크기" + result.capacity());
		return result.toString();
	}
	@RequestMapping(value = "/showDetail.do", method = RequestMethod.POST,  produces= "text/html; charset=UTF-8")
	@ResponseBody
	public String showDetail(@ModelAttribute RentalVO rvo, @RequestParam(value = "index") int index) {
		
		List<ItemsRentalVO> itemsList = ItemsRentalService.getItemsRentalList(rvo.getR_no());
		StringBuffer result = new StringBuffer();
		result.append("<input type='hidden' id='list-index' value='");
		result.append(index);
		result.append("' />");
		
		result.append("<table>");
		result.append("<tr><td>신청자</td><td>");
		result.append(rvo.getM_id());
		result.append("</td></tr><tr><td>연락처</td><td>");
		result.append(rvo.getR_account());
		result.append("</td></tr>");
		
		result.append("<tr><td>대관 등록일</td><td>");
		result.append(rvo.getR_regdate());
		result.append("</td></tr><tr><td>예약시간</td><td>");
		result.append(rvo.getR_reserve_date());
		result.append("</td></tr>");
		
		result.append("<tr><td>경기장</td><td>");
		result.append(rvo.getR_start());
		result.append("</td></tr><tr><td>총 결제금액</td><td>");
		result.append(rvo.getR_total_pay());
		result.append(" 원</td></tr>");
		result.append("</table>");
		if( !itemsList.isEmpty() ) {
			result.append("<div><h2>대여용품</h2>");
			result.append("<ul>");
			for(ItemsRentalVO irvo : itemsList) {
				result.append("<li data-num='");
				result.append(irvo.getIr_no());
				result.append("'>");
				result.append("<p><span>");
				result.append(irvo.getI_name());
				result.append("</span>&nbsp&nbsp");
				result.append("<span>");
				result.append(irvo.getIr_rental_ea());
				result.append("개</span>");
				result.append("</p>");
				result.append("<span class='toggle-wrap'><input type='checkbox' class='toggle'");
				if( irvo.getIr_return_status() == 2) {
					result.append(" checked value = '2'");
				}else {
					result.append(" value = '1' ");
				}
				result.append("id='");
				result.append(irvo.getIr_no());
				result.append("' /><label for='");
				result.append(irvo.getIr_no());
				result.append("' class='toggle-btn'></label></span></li>");
			}
			result.append("</ul></div>");
		}
		return result.toString();
	}
	
    // 환불 현황 리스트
    @RequestMapping(value = "/refundList.do", method = RequestMethod.GET)
    public String getRefundList(
    		@ModelAttribute RentalVO rvo,
    		@ModelAttribute MemberVO mvo,
    		@ModelAttribute PlaceVO pvo,
    		Model model
    		) {
        
        System.out.println("getRefundList 호출 성공");
        
        Paging.setPage(rvo, 15);
        String pageSize = rvo.getPageSize();
		int total = clientRentalService.refundListCnt();
		int count = total - (Util.nvl(rvo.getPage()) -1 ) * Util.nvl(rvo.getPageSize());
		
		List<Map<String, String>> refundList = clientRentalService.getRefundList(pvo);
		model.addAttribute("refundList", refundList);
		System.out.println(refundList);
		
		String register = clientRentalService.getRegdate(mvo.getM_id());
		model.addAttribute("register", register);
        
        return "/rental/refundList";
    }
    
    // 온라인대관 환불요청
    @RequestMapping(value = "/refundUpdate.do", method = RequestMethod.POST, produces= "text/html; charset=UTF-8")
    @ResponseBody
    public String refundUpdate(@RequestParam(value = "r_no") int r_no) {
    	
    	int result = clientRentalService.refundUpdate(r_no);
    	
    	
    	
    	return result + "";
    }
    // 오프라인대관 대관취소
    @RequestMapping(value = "/deleteRental.do", method = RequestMethod.POST, produces= "text/html; charset=UTF-8")
    @ResponseBody
    public String deleteRental(@RequestParam(value = "r_no") int r_no) {
    	
    	int result = clientRentalService.deleteRental(r_no);
    	
    	return result + "";
    }
    
	
	  @RequestMapping(value = "/updateItems_rental.do", method = RequestMethod.POST, produces= "text/html; charset=UTF-8")
	  
	  @ResponseBody public String updateItems_rental(@ModelAttribute ItemsRentalVO irvo) {
		 
		  int result = 0;
		  System.out.println(irvo.toString());
		  try {
			  // 상태변경 ㄱ
			  result = ItemsRentalService.updateStatus(irvo);
			  
		  }catch(Exception e){
			  e.printStackTrace();
			  System.out.println(e.toString());
			  result = 0;
		  }
		  
		  return result+"";
	  }
	  
	  // 환불 관리 상세 페이지
	  @RequestMapping(value = "/detailRefund.do", method = RequestMethod.POST)
	  public String getDetailRefund(
			  @ModelAttribute RentalVO rvo,
			  Model model
			  ) {
		  System.out.println("getDetailRefund 호출 성공");
		  
		  int r_no = rvo.getR_no();
		  rvo = clientRentalService.getDetailRefund(r_no);
		  model.addAttribute("rvo", rvo);
		  System.out.println(rvo);
		  
		  return "/rental/detailRefund";
	  }
	 
}
