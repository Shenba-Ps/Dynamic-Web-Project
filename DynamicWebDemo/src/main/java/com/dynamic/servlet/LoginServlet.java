package com.dynamic.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dynamic.dao.UsermasterDao;
import com.dynamic.model.UserMaster;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsermasterDao dao;
  
	
    public LoginServlet() {
        this.dao=new UsermasterDao();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		
		if(username == null || username == ""){
			
			request.setAttribute("status", "invalid username");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
        if(password == null || password == ""){
			
        	request.setAttribute("status", "invalid password");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
        UsermasterDao userMasterDao=new UsermasterDao();
        try {
		UserMaster userMaster =	userMasterDao.selectUserByUsernamePassword(username, password);
		
		if(userMaster == null) {
			response.sendRedirect("login.jsp");
		}
		
		
		if(userMaster.getType().equals("S")) {
			response.sendRedirect("PersonalDetail.jsp");
		}
		
		if(userMaster.getType().equals("A")) {
			response.sendRedirect("StaffManagement.jsp");
		}
	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        dispatcher.forward(request, response);
	}

}
