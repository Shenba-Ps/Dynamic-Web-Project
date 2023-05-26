package com.dynamic.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dynamic.model.UserMaster;

public class UsermasterDao {
	private String jdbcUrl="jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
	private String jdbcUsername="shenba";
	private String jdbcPassword="shenbagarajan";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO user_master" + "  (user_name,password,created_date,modified_date,type,lock_tag,status,active) VALUES "
			+ " (?, ?, ?,?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id,name,email,country from user_master where id =?";
	private static final String SELECT_ALL_USERS = "select * from user_master";
	private static final String DELETE_USERS_SQL = "delete from user_master where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user_master set user_name = ?,password= ?, created_date =?, modified_date = ?,type = ?,log_tag = ?, status = ? where id = ?;";
	private static final String SELECT_USERNAME_PASSWORD="select * from user_master where user_name = ? and password = ?";

	
	public UsermasterDao() {
	}
	
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
	
	public void insertUser(UserMaster user) throws SQLException {
		String result = "Data entered successfully";
		System.out.println(INSERT_USERS_SQL);
		try(Connection connection= getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL)){
			java.util.Date created=user.getCreatedDate();
			java.util.Date modified=user.getCreatedDate();
			java.sql.Date d=new java.sql.Date(created.getTime());
			java.sql.Date m=new java.sql.Date(modified.getTime());
			preparedStatement.setString(1,user.getUserName() );
			preparedStatement.setString(2,user.getPassword() );
			preparedStatement.setDate(3,d );
			preparedStatement.setDate(4,m );
			preparedStatement.setString(5,user.getLockTag() );
			preparedStatement.setString(6,user.getType() );
			preparedStatement.setString(7,user.getStatus() );
			preparedStatement.setString(8, "1");

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			printSQLException(e);
		}
//		return result;
	}
	

	public UserMaster selectUserByUsernamePassword(String user_name,String password) throws SQLException {
		UserMaster user=null;
		try(Connection connection= getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USERNAME_PASSWORD)){
			preparedStatement.setString(1, user_name);
			preparedStatement.setString(2, password);
			System.out.println(preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
//			HttpSession session=req
			while(rs.next()) {
				String uname = rs.getString("user_name");
				String pass = rs.getString("password");
				String type=rs.getString("type");
				
				user = new UserMaster(uname, pass,type);
			}
		}catch (SQLException e) {
				printSQLException(e);
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

}
