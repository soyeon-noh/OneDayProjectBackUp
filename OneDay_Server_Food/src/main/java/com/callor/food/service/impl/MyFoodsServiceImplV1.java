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
	public Integer insert(MyFoodVO myFoodVO) {
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (my_seq, my_date, my_fcode, my_intake) ";
		sql += " VALUES (seq_myFoods.NEXTVAL, ?, ?, ?) ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.setString(1, myFoodVO.getMy_date());
			pStr.setString(2, myFoodVO.getMy_fcode());
			pStr.setInt(3, myFoodVO.getMy_intake());
			pStr.executeUpdate();
			
			pStr.close();
			
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
	public List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException{
		List<MyFoodDTO> myFoodList = new ArrayList<MyFoodDTO>();
		int intake = 0;
		
		ResultSet rSet = pStr.executeQuery();
		
		while( rSet.next()) {
			MyFoodDTO myFoodDTO = new MyFoodDTO();
			myFoodDTO.setMy_date(rSet.getString("날짜"));
			myFoodDTO.setFd_name(rSet.getString("식품명"));
			myFoodDTO.setMy_intake(rSet.getInt("섭취량"));
			intake = myFoodDTO.getMy_intake();
			myFoodDTO.setFd_code(rSet.getString("식품코드"));
			myFoodDTO.setFd_content(rSet.getInt("총내용량(g)") * intake);
			myFoodDTO.setFd_calories(rSet.getInt("에너지(kcal)") * intake);
			myFoodDTO.setFd_protein(rSet.getInt("단백질(g)") * intake);
			myFoodDTO.setFd_fat(rSet.getInt("지방(g)") * intake);
			myFoodDTO.setFd_carbo(rSet.getInt("탄수화물(g)") * intake);
			myFoodDTO.setFd_sugar(rSet.getInt("총당류(g)") * intake);
			myFoodList.add(myFoodDTO);
		}
		rSet.close();
		// pStr.close();
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
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFoodDTO> selectByDate(String date) {
		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE 날짜 = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.setString(1, date);
			
			List<MyFoodDTO> myFoodList = this.select(pStr);
			pStr.close();
			return myFoodList;
			//	pStr.setString(1, my_date.trim());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<MyFoodDTO> selectByName(String fd_name) {
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명 = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.setString(1, fd_name);
			
			List<MyFoodDTO> myFoodList = this.select(pStr);
			pStr.close();
			return myFoodList;
			//	pStr.setString(1, my_date.trim());
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	
	
}
