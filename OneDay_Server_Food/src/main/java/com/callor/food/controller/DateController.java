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

@WebServlet("/date/*")
public class DateController extends HttpServlet{
	private static final long serialVersionUID = -1205231673048782193L;
	
	protected MyFoodsService mService;

	public DateController() {
		mService = new MyFoodsServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		String fd_name = req.getParameter("fd_name");
		List<MyFoodDTO> myFoodList = mService.selectByDate(fd_name);
		ServletContext app = this.getServletContext();
		app.setAttribute("DATEFOODS", myFoodList );
		
		RequestDispatcher disp
			= app.getRequestDispatcher("/WEB-INF/views/date.jsp");
		
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		System.out.println(subPath);

		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		
	}

	
}
