package com.callor.food.service;

import java.util.List;

import com.callor.food.model.MyFoodDTO;
import com.callor.food.model.MyFoodVO;

//myfoods table의 조회, 입력을 구현하기 위한 인터페이스 선언
public interface MyFoodsService {

	// CREATE 데이터 추가
	public Integer insert(MyFoodVO myFoodVO);
	
	// READ 데이터 조회
	public List<MyFoodDTO> selectAll();
	
	// READ 날짜로 데이터 조회
	public List<MyFoodDTO> selectByDate(String date);
	
	// READ 식품코드로 데이터 조회
	public List<MyFoodDTO> selectByName(String fname);
}
