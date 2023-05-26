package com.dynamic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.dynamic.model.StaffPersonalDetails;

public class PersonalDetailDao {

	private String jdbcUrl="jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
	private String jdbcUsername="shenba";
	private String jdbcPassword="shenbagarajan";
	
	private static final String INSERT_Personal_Details_SQL = "INSERT INTO staff_detail" + "  (first_name,middle_name,last_name,dob,address1,address2,"
			+ "email,mobile,phone,department_code,staff_type,post_box,status) VALUES "
			+ " (?, ?, ?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_Personal_Detail_By_Id = "select * from staff_detail where staff_id = ?";
	
	private static final String SELECT_ALL_USERS = "select * from staff_detail";
	
	protected Connection getConnection() {
		Connection connection = null ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	public void insertPersonalDetails(StaffPersonalDetails personaldetails) throws SQLException {
		String result = "Data entered successfully";
		System.out.println(INSERT_Personal_Details_SQL);
		try(Connection connection= getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_Personal_Details_SQL)){
			java.util.Date modifiedDOB=personaldetails.getDob();
			java.sql.Date m=new java.sql.Date(modifiedDOB.getTime());
			preparedStatement.setString(1,personaldetails.getFirstName() );
			preparedStatement.setString(2,personaldetails.getMiddleName() );
			preparedStatement.setString(3,personaldetails.getLastName() );
			preparedStatement.setDate(4,(Date) m );
			preparedStatement.setString(5,personaldetails.getAddress1() );
			preparedStatement.setString(6,personaldetails.getAddress2() );
			preparedStatement.setString(7,personaldetails.getEmail() );
			preparedStatement.setString(8,personaldetails.getMobile());
			preparedStatement.setString(9,personaldetails.getPhone());
			preparedStatement.setString(10,personaldetails.getDeptCode());
			preparedStatement.setString(11,personaldetails.getStaffType());
			preparedStatement.setLong(12,personaldetails.getPostBox());
			preparedStatement.setString(13,personaldetails.getStatus());


			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			printSQLException(e);
		}
//		return result;
	}
	
	
	public StaffPersonalDetails getUserById(int id) throws SQLException {
		StaffPersonalDetails user = null;
		try(Connection connection= getConnection();
				PreparedStatement ps=connection.prepareStatement(SELECT_Personal_Detail_By_Id)){
			ps.setInt(1, id);
		ResultSet rs =	ps.executeQuery();
		
		while(rs.next()) {
			String firstName = rs.getString("first_name");
			 String middleName= rs.getString("middle_name");
			 String lastName= rs.getString("last_name");
			 String dob= rs.getString("dob");
			 String address1= rs.getString("address1");
			 String address2= rs.getString("address2");
			 String email= rs.getString("email");
			 String mobile= rs.getString("mobile");
			 String phone= rs.getString("phone");
			 String staffType= rs.getString("staff_type");
			 String deptCode= rs.getString("department_code");
			 int postBox= Integer.parseInt(rs.getString("post_box"));
			 String status= rs.getString("status");
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY", Locale.ENGLISH);
				Date dateOfBirth = null;
				try {
					dateOfBirth = (Date) formatter.parse(dob);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			user = new StaffPersonalDetails(firstName,lastName,middleName,dateOfBirth,address1,address2,email,
					mobile,phone,staffType,deptCode,postBox,status);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}



	public List<StaffPersonalDetails> getAllUser() throws SQLException, ParseException {
		
		
			List<StaffPersonalDetails> userList = new ArrayList<>();
			try(Connection connection= getConnection();
					PreparedStatement ps=connection.prepareStatement(SELECT_ALL_USERS)){
				ResultSet rs =	ps.executeQuery();
				
				while(rs.next()) {
					String firstName = rs.getString("first_name");
					 String middleName= rs.getString("middle_name");
					 String lastName= rs.getString("last_name");
					 Date dob= Date.valueOf(rs.getString("dob")) ;
					 System.out.println(dob);
					 String address1= rs.getString("address1");
					 String address2= rs.getString("address2");
					 String email= rs.getString("email");
					 String mobile= rs.getString("mobile");
					 String phone= rs.getString("phone");
					 String staffType= rs.getString("staff_type");
					 String deptCode= rs.getString("department_code");
					 int postBox= Integer.parseInt(rs.getString("post_box"));
					 String status= rs.getString("status");
//					 SimpleDateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");					
//					 String date = fechas.format(dob);
//					 System.out.println(date);
//					 Date newFormateDate=(java.sql.Date) fechas.parse(date);
//					 System.out.println(newFormateDate);
//					 System.out.println(date);
					 
						
						
						userList.add(new StaffPersonalDetails(firstName,lastName,middleName,dob,address1,address2,email,
							mobile,phone,staffType,deptCode,postBox,status));
				}
			}
			return userList;
		
	}
	
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
}
