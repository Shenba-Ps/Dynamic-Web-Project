<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
            input {
            
                width: 20%;
                padding: 6px 6px;
                margin: 8px 0;
                box-sizing: border-box;
            }
             .row:after {
                content: "";
                display: table;
                clear: both;
            }
            .col-25 {
                float: left;
                width: 10%;
               
            }
              .col-75 {
                float: left;
                width: 75%;
               
            }
            label {
                padding: 3px 3px 3px 0;
                
            }
           
     </style>       

</head>
<body>
<h1>Staff Details</h1>
<div align="center">
<form align="" action="" method="">



     <div class="row">
                <div class="col-25">
                    <label for="firstname">First Name</label>
                </div>
                <div class="col-75">
                    <input type="text" name="firstname">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="middlename">Middle Name</label>
                </div>
                <div class="col-75">
                    <input type="text" name="middlename">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="lastname">Last name</label>
                </div>
                <div class="col-75">
                    <input type="text" name="lastname">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="dob">DOB</label>
                </div>
                <div class="col-75">
                    <input type="date" name="dob">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="address1">Address 1</label>
                </div>
                <div class="col-75">
                    <input type="text" name="address1">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="address1">Address 2</label>
                </div>
                <div class="col-75">
                    <input type="text" name="address1">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="email">Email</label>
                </div>
                <div class="col-75">
                    <input type="email" name="email">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="mobile">Mobile</label>
                </div>
                <div class="col-75">
                    <input type="number" name="mobile">
                </div>
            </div>
             <div class="row">
                <div class="col-25">
                    <label for="phone">Phone</label>
                </div>
                <div class="col-75">
                    <input type="number" name="phone">
                </div>
            </div>
            
             <div class="row">
             <div class="col-25">
             <label for="deptcode">Dept_code</label>
             </div>
               <select name="deptcode" id="deptcode">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option>
</select>
            </div>
            
            
             <div class="row">
             <div class="col-25">
             <label for="stafftype">Staff Type</label>
             </div>
               <select name="stafftype" id="stafftype">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option>
</select>
            </div>
            
             <div class="row">
                <div class="col-25">
                    <label for="postbox">Post Box</label>
                </div>
                <div class="col-75">
                    <input type="number" name=""postbox"">
                </div>
            </div>
          
           
            <div class="row">
             <div class="col-25">
             <label for="status">Status</label>
             </div>
               <select name="status" id="status">
  <option value="active">Active</option>
  <option value="inactive">Inactive</option>
 
</select>
            </div>     
                
                
                
                <button align ="center" type="submit">Add</button>  
                
                <button type="submit">View</button>
                
                <button type="submit">Modify</button>
                   
            
</form>
</div>
</body>
</html>