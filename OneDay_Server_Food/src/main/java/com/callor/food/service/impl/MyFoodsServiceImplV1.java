package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.food.model.MyFoodDTO;
import com.callor.food.model.MyFoodVO;
import com.callor.food.persistence.DBContract;
import com.callor.food.service.MyFoodsService;

public class MyFoodsServiceImplV1 implements MyFoodsService{

	protected Connection dbConn;
	
	public MyFoodsServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	
	@Override
	public void insert(MyFoodVO myFoodVO) {
		
	}
	
	public List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException{
		List<MyFoodDTO> myFoodList = new ArrayList<MyFoodDTO>();
		
		ResultSet rSet = pStr.executeQuery();
		
		while( rSet.next()) {
			MyFoodDTO myFoodDTO = new MyFoodDTO();
			myFoodDTO.setMy_date(rSet.getString("my_date"));
			myFoodDTO.setFd_name(rSet.getString("fd_name"));
			myFoodDTO.setMy_intake(rSet.getInt("my_intake"));
			myFoodDTO.setFd_content(rSet.getInt("fd_content"));
			myFoodDTO.setFd_calories(rSet.getInt("fd_calories"));
			myFoodDTO.setFd_protein(rSet.getInt("fd_protein"));
			myFoodDTO.setFd_fat(rSet.getInt("fd_fat"));
			myFoodDTO.setFd_carbo(rSet.getInt("fd_carbo"));
			myFoodDTO.setFd_sugar(rSet.getInt("fd_sugar"));
			myFoodList.add(myFoodDTO);
		}
//		pStr.close();
		return myFoodList;
	}

	@Override
	public List<MyFoodDTO> selectAll() {
		
		String sql = " SELECT * FROM view_섭취정보 ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> myFoodList = this.select(pStr);
			pStr.close();
			return myFoodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFoodVO> selectByDate() {
		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE 날짜 = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			//	pStr.setString(1, my_date.trim());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
