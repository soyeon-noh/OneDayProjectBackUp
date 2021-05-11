package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodsDTO;
import com.callor.food.service.FoodsService;
import com.callor.food.service.MyFoodsService;
import com.callor.food.service.impl.FoodsServiceImplV1;
import com.callor.food.service.impl.MyFoodsServiceImplV1;

@WebServlet("/insert/*")
public class InsertController extends HttpServlet{
	private static final long serialVersionUID = 7047762146045343910L;
	
	protected MyFoodsService mService;
	protected FoodsService fService;
	
	public InsertController() {
		mService = new MyFoodsServiceImplV1();
		fService = new FoodsServiceImplV1();
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO insert
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO insert/serarch
		String subPath = req.getPathInfo();
		System.out.println(subPath);
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();


		if(subPath.endsWith("/search")) {
			String fd_name = req.getParameter("fd_name");
			String fcode = req.getParameter("code");
			
			System.out.println(fd_name);
			System.out.println(fcode);
			
			if(fd_name == null || fd_name.equals("")) {
				out.println("상품명을 입력하세요");
				out.close();
			}else {
				
				List<FoodsDTO> foodsList = fService.selectByName(fd_name);
				req.setAttribute("NAMEFOODS", foodsList);	
				req.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(req, resp);
			}
		}
		
		
		// insert 정보넣기

		 
		
		
	}
}
