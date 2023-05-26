<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css" >
table, th, td {
  border: 1px solid;
  padding: 5px;
}
table {
  width: 100%;
  text-align: center;
   border-collapse: collapse;
}
</style>
</head>
<body>
<div align="center">
		<table>
		<thead>
					<tr>
					<th>SI.NO</th>
						 
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
						<th>DOB</th>
						<th>Address 1</th>
						<th>Address 2</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Phone</th>
						<th>Department Code</th>
						<th>Staff Type</th>
						<th>post box</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
		<tbody>
		
		            <c:forEach  var="staff" items="${listStaff}" varStatus="counter"> 
		            
		            <tr>
		                   <td> ${counter.count} </td>
		                   
							<td><c:out value="${staff.firstName}" /></td>
							<td><c:out value="${staff.lastName}" /></td>
							<td><c:out value="${staff.middleName}" /></td>
							<td><c:out value="${staff.dob}" /></td>
							<td><c:out value="${staff.address1}" /></td>
							<td><c:out value="${staff.address2}" /></td>
							<td><c:out value="${staff.email}" /></td>
							<td><c:out value="${staff.mobile}" /></td>
							<td><c:out value="${staff.phone}" /></td>
							<td><c:out value="${staff.deptCode}" /></td>
							<td><c:out value="${staff.staffType}" /></td>
							<td><c:out value="${staff.postBox}" /></td>
							<td><c:out value="${staff.status}" /></td>
							<td><a href="edit?id=<c:out value='${staff.staff_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${staff.staff_id}' />">Delete</a></td>
		            
		            
		            
		            </tr>
		            
		            </c:forEach>
		
		
		
		</tbody>
		</table>
		</div>	
</body>
</html>