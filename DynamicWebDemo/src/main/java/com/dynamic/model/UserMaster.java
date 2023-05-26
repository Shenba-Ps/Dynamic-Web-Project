package com.dynamic.model;


import java.util.Date;

public class UserMaster {
	private int id;
	private String userName;
	private String password;
   
    private Date createdDate;
    private Date modifiedDate;
    private String lockTag;
    private String type;
    private String status;
    
    
	public UserMaster() {
		super();
	}


	public UserMaster(String userName, String password, String type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}


	public UserMaster(String userName, String password, Date createdDate, Date modifiedDate, String logTag, String type,
			String status) {
		super();
		this.userName = userName;
		this.password = password;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.lockTag = logTag;
		this.type = type;
		this.status = status;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	


	public String getLockTag() {
		return lockTag;
	}


	public void setLockTag(String lockTag) {
		this.lockTag = lockTag;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserMaster(int id, String userName, String password, Date createdDate, Date modifiedDate, String logTag,
			String type, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.lockTag = logTag;
		this.type = type;
		this.status = status;
	}
	
	
    
    
}
