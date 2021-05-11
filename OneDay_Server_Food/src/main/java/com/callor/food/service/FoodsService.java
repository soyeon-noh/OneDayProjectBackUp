package com.callor.food.service;


import java.util.List;

import com.callor.food.model.FoodsDTO;
import com.callor.food.model.MyFoodVO;

public interface FoodsService {

	public List<FoodsDTO> selectByName(String fd_name);
	public Integer insert(MyFoodVO myFoodVO);
	public String search();
}
