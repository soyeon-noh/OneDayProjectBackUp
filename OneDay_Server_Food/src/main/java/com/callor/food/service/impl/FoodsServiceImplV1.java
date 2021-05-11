package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.food.model.FoodsDTO;
import com.callor.food.model.MyFoodVO;
import com.callor.food.persistence.DBContract;
import com.callor.food.service.FoodsService;

public class FoodsServiceImplV1 implements FoodsService {

	protected Connection dbConn;
	
	public FoodsServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	public List<FoodsDTO> select(PreparedStatement pStr) throws SQLException{
		List<FoodsDTO> foodsList = new ArrayList<FoodsDTO>();
		
		ResultSet rSet = pStr.executeQuery();
		
		while( rSet.next()) {
			FoodsDTO foodsDTO = new FoodsDTO();
			foodsDTO.setFd_code(rSet.getString("식품코드"));
			foodsDTO.setFd_name(rSet.getString("식품명"));
			foodsDTO.setFd_year(rSet.getString("출시연도"));
			foodsDTO.setCp_code(rSet.getString("제조사코드"));
			foodsDTO.setCp_name(rSet.getString("제조사명"));
			foodsDTO.setIt_code(rSet.getString("분류코드"));
			foodsDTO.setIt_name(rSet.getString("분류명"));
			foodsDTO.setFd_container(rSet.getInt("1회제공량") );
			foodsDTO.setFd_content(rSet.getInt("총내용량(g)"));
			foodsDTO.setFd_calories(rSet.getInt("에너지(kcal)"));
			foodsDTO.setFd_protein(rSet.getInt("단백질(g)") );
			foodsDTO.setFd_fat(rSet.getInt("지방(g)"));
			foodsDTO.setFd_carbo(rSet.getInt("탄수화물(g)"));
			foodsDTO.setFd_sugar(rSet.getInt("총당류(g)"));

			foodsList.add(foodsDTO);
		}
		rSet.close();
		// pStr.close();
		return foodsList;
	}
	
	
	public List<FoodsDTO> selectByName(String fd_name) {
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			
			pStr.setString(1, fd_name);
			
			List<FoodsDTO> myFoodList = this.select(pStr);
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
	public String search() {
		String sql = " SELECT INTO tbl_myfoods ";
		sql += " (my_seq, my_date, my_fcode, my_intake) ";
		sql += " VALUES (seq_myFoods.NEXTVAL, ?, ?, ?) ";
		
		return null;
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
			
			
			pStr.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


}
