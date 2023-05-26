package com.dynamic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dynamic.dao.PersonalDetailDao;
import com.dynamic.model.StaffPersonalDetails;

/**
 * Servlet implementation class StaffPersonalDetailServlet
 */
@WebServlet("/")
public class StaffPersonalDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PersonalDetailDao pDetailDao;
 
    public StaffPersonalDetailServlet() {
        this.pDetailDao=new PersonalDetailDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch(action) {
		case "/insert":
			insertUser(request,response);
			break;
		case"/updatePersonalDetails":
			updatePersonalDetails(request,response);
			break;
		case"/edit":
			try {
				showEditForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default:
			try {
				listUser(request,response);
			} catch (SQLException | ServletException | IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		}
	}

	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
			List<StaffPersonalDetails> listStaff = pDetailDao.getAllUser();
			request.setAttribute("listStaff", listStaff);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Staff-list.jsp");
			dispatcher.forward(request, response);
			
		
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		StaffPersonalDetails existingUser = pDetailDao.getUserById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		request.setAttribute("user", existingUser);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updatePersonalDetails(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String firstName = request.getParameter("firstname");
		 String middleName= request.getParameter("middlename");
		 String lastName= request.getParameter("lastname");
		 String dob= request.getParameter("dob");
		 String address1= request.getParameter("address1");
		 String address2= request.getParameter("address2");
		 String email= request.getParameter("email");
		 String mobile= request.getParameter("mobile");
		 String phone= request.getParameter("phone");
		 String staffType= request.getParameter("stafftype");
		 String deptCode= request.getParameter("deptcode");
		 int postBox= Integer.parseInt(request.getParameter("postbox"));
		 String status= request.getParameter("status");
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateOfBirth = null;
		try {
			dateOfBirth = formatter.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StaffPersonalDetails spd = new StaffPersonalDetails(firstName,lastName,middleName,dateOfBirth,address1,address2,email,
				mobile,phone,staffType,deptCode,postBox,status);
		if(spd.getStatus().equalsIgnoreCase("active")) {
			spd.setStatus("1");
		}
		try {
			pDetailDao.insertPersonalDetails(spd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}response.sendRedirect("PersonalDetail.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
