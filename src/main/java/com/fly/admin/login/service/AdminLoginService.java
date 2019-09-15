package com.fly.admin.login.service;

import java.util.List;

import com.fly.admin.statistics.vo.StatisticsVO;

public interface AdminLoginService {

	/*
	 * // 회원가입 수 public int registCnt(String date);
	 * 
	 * // 구장 등록 수 오늘, 이번달, 누적 수 public int placeCnt(String date);
	 * 
	 * // 대관 예약 수 오늘, 이번달, 누적 수 public int rentalCnt(String date);
	 * 
	 * // 매치 게시판 등록 오늘, 이번달, 누적 수 public int matchCnt(String date);
	 * 
	 * // 용병 게시판 등록 오늘, 이번달, 누적 수 public int supportCnt(String date);
	 */
	
	// admin 사이트 통계
	public List<StatisticsVO> getStatistics();
	
}
