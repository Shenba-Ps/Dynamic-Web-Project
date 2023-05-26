package com.dynamic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dynamic.dao.UsermasterDao;
import com.dynamic.model.UserMaster;

/**
 * Servlet implementation class UserRegServlet
 */
@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
	    String confirmPassword = request.getParameter("confirmPassword");
        String createdDate = request.getParameter("createdDate");  
		String modifiedDate =request.getParameter("modifiedDate");
		String type = request.getParameter("type");
		String lockTag = request.getParameter("lockTag");
		String status= request.getParameter("status");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date modifieddate = null;
		Date createddate = null;

		try {
			createddate = formatter.parse(createdDate);

			modifieddate = formatter.parse(modifiedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMaster userMaster =new UserMaster(userName,password,createddate,modifieddate,type,lockTag,status);
	     
		UsermasterDao userMasterDao=new UsermasterDao();
		try {
			userMasterDao.insertUser(userMaster);
			response.sendRedirect("UserRegistration.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}


