package com.fly.client.items.service;

import java.util.List;

import com.fly.client.items.vo.ItemsVO;

public interface ItemsService {
	
	// 해당구장의 상품리스트를 가져온다
	public List<ItemsVO> searchItemsList(String p_num);
}
