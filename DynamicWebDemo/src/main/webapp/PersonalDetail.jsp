<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";%>
<%!String user = "shenba";%>
<%!String psw = "shenbagarajan";%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.required::after{
content: " *";
color: red;
}

</style>


</head>
<body>
<div align="center">
  <h1>Staff Personal details</h1>
  <form id="form" onsubmit="validateInputs()" action="<%= request.getContextPath() %>/insert" method="get"  >
   <table style="with: 80%">
   
    <tr>
     <td class="required">First Name</td>
     <td><input type="text" name="firstname" id="firstname" class="required" /><label style="color: red;">*</label>
     <span id = "firstnameerr"></span> </td>
    
    </tr>
    <tr>
     <td>Middle Name</td>
     <td><input type="text" name="middlename" class="required"/></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastname" class="required"/></td>
    </tr>
    
    <tr>
     <td>DOB</td>
     <td><input type="date" name="dob" /></td>
    </tr>
    <tr>
     <td>Address1</td>
     <td><input type="text" name="address1" /></td>
    </tr>
    <tr>
     <tr>
     <td>Address2</td>
     <td><input type="text" name="address2" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="email" name="email" /></td>
    </tr>
     <tr>
     <td>Mobile</td>
     <td><input type="number" name="mobile" /></td>
    </tr>
    <tr>
    <td>Phone</td>
     <td><input type="number" name="phone" /></td>
    </tr>
    
     <tr>
      <td>Dept_code</td>
      <td> <select name="deptcode" id="deptcode">
      <option value="volvo">Volvo</option>
      <option value="saab">Saab</option></select> </td>
     
    </tr>
    
    <tr>
      <td>Staff type</td>
      <td> <select name="stafftype" id="stafftype">
      <option >Select</option>
      
      <%
      try{
    	  Class.forName(driverName);
    	  Connection con = DriverManager.getConnection(url, user, psw);
    	  Statement sm = con.createStatement();
    	  String query= "select type from user_master";
    	  ResultSet rs = sm.executeQuery(query);
    	  while(rs.next()){
    		  %>
    		  <option><%=rs.getString("type") %></option>
    		  <% 
    	  }
    	  
      }catch(Exception e){
    	  
      }
      %>
      </select> </td>
     
    </tr>
    
    <tr>
    <td>Post Box</td>
     <td><input type="number" name="postbox" /></td>
    </tr>
    
    <tr>
      <td>Status</td>
      <td> <select name="status" id="status">
      <option value="active">Active</option>
      <option value="inactive">Inactive</option></select> </td>
     
    </tr>
   </table>
   <button type="submit">Add</button>

   <button type="button" onclick="test()">Add</button>

 
  </form>
  
 </div>
<script type="text/javascript">
const form = document.getElementById('form');
debugger;
form.addEventListener('submit',(e)=>{
    
    if(!validateInputs()){
        e.preventDefault();
    }
})
function validateInputs(){
	debugger;
	const firstname = document.getElementById('firstname')
	const firstnameValue = firstname.value.trim()
	let success=true;
	if(firstnameValue == ''){
		document.getElementById('firstnameerr').innerHTML="test";
		alert("print")
		success=false;
	}
	else{
		alert("test")
		success=true;
	}
	return success;
	}

</script>
 </body>
</html>