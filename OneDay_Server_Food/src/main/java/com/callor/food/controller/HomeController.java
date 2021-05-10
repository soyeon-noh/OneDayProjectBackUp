package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.MyFoodDTO;
import com.callor.food.service.MyFoodsService;
import com.callor.food.service.impl.MyFoodsServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 2486075485629848361L;

	private MyFoodsService mService;
	
	public HomeController() {
		mService = new MyFoodsServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
		List<MyFoodDTO> myFoodList = mService.selectAll();
		
		ServletContext app = this.getServletContext();
		app.setAttribute("FOOD", myFoodList );
		
		RequestDispatcher disp
			= app.getRequestDispatcher("/WEB-INF/views/home.jsp");
		
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		System.out.println(subPath);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//if (subPath.equals("/"))
		
	}


	

	
	
}
