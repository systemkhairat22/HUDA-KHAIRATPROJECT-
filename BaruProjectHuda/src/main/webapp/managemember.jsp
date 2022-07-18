<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//prevent Caching of JSP Pages
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
//get session and check if session null, go to login page
if (session.getAttribute("currentSessionUser") == null)
	response.sendRedirect("index.html");
%>
<%int id = (Integer) session.getAttribute("currentSessionUser");%>
<!DOCTYPE html>
<html>
<style>
/navbar/
* {
  box-sizing: border-box;
}

body {
  margin: 0px;
  font-family: 'Arial','Verdana';

}

.nav {
  padding: 0px 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 80px;
  width: 100%;
  background-color:#143d59	;
  position: relative;
}

.nav > .nav-header {
  display: inline;
}

.nav > .nav-header > .nav-title {
  display: inline-block;
  font-size: 22px;
  color: #fcc729;
  padding: 10px 10px 10px 10px;
}

.nav > .nav-btn {
  display: none;
}

.nav > .nav-links {
  display: inline;
  float: right;
  font-size: 15px;
  text-transform: uppercase;
}

.nav > .nav-links > a {
  display: inline-block;
  padding: 13px 10px 13px 10px;
  text-decoration: none;
  color: #9fafca;
}

.nav > .nav-links > a:hover {
  background-color: rgba(0, 0, 0, 0.3);

}

.nav > .nav-links > a.active {
 background-color: rgba(255, 255, 255, 0.15)

}

.nav > #nav-check {
  display: none;
}

@media (max-width:800px) {
  .nav > .nav-btn {
    display: inline-block;
    position: absolute;
    right: 0px;
    top: 0px;
    transform: translate(-12px, 14px);
  }
  .nav > .nav-btn > label {
    display: inline-block;
    width: 50px;
    height: 50px;
    padding: 13px;
  }
  .nav > .nav-btn > label:hover,.nav  #nav-check:checked ~ .nav-btn > label {
    background-color: rgba(0, 0, 0, 0.3);
  }
  .nav > .nav-btn > label > span {
    display: block;
    width: 25px;
    height: 10px;
    border-top: 2px solid #eee;
  }
  .nav > .nav-links {
    position: absolute;
    display: block;
    width: 100%;
    background-color: #323232 ;
    height: 0px;
    transition: all 0.3s ease-in;
    overflow-y: hidden;
    top: 80px;
    left: 0px;
  }

  .nav > .nav-links > a {
    display: block;
    width: 100%;
    padding: 13px 30px 13px 30px;
  }
  .nav > #nav-check:not(:checked) ~ .nav-links {
    height: 0px;
  }
  .nav > #nav-check:checked ~ .nav-links {
    height: calc(100vh - 80px);
    overflow-y: auto;
    z-index: 2;
  }
}
.top-nav{

                background-color: rgba(0,0,0, 0.9);
                color: white;
                flex-flow: row wrap;

            }
input[type=button], input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 10px 30px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}


input[type=button], input[type=reset] {
  background-color:#DC7633;
  border: none;
  color: white;
  padding: 10px 30px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}


.footer {

  padding: 0.1px;

  text-align: center;
    position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: #143d59	;
  color: white;
  text-align: center;
}

</style>
<body>
 <!-- Responsive navbar-->
        <div class="nav">
              <input type="checkbox" id="nav-check">
              <div class="nav-header">
                <div class="nav-title d-flex align-items-center">
                  <p class="mb-brand">Manage Profile</p>
                </div>
              </div>
              <div class="nav-btn">
                <label for="nav-check">
                  <span></span>
                  <span></span>
                  <span></span>
                </label>
              </div>
              
              <div class="nav-links"> 
                <a href= " homemember.jsp">Home</a> 
                <a href= " paymentmethod">Make Payment</a>  
                <a href = " ">Claim Khairat</a>
                <a href = "index.html ">Log out</a>
                <a></a>  
                <a></a>  

              </div>
        </div>


	<h1>MANAGE PROFILE</h1>
	<form action="ManageProfileMemberController?action=update_profile" method="post">
		<table>
			<tbody>
				<tr>
					<td>MEMBER ID</td>
					<td>${m.memberid}</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>${m.mem_name}</td>
				</tr>
				<tr>
					<td>IC NUMBER</td>
					<td>${m.mem_icnum}</td>
				</tr>
				<tr>
					<td>AGE</td>
					<td><input type="number" name="mem_age" value="${m.mem_age}"/></td>
				</tr>
				<tr>
					<td>ADRESS</td>
					<td><input type="text" name="mem_address" value="${m.mem_address}"/></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="mem_email" value="${m.mem_email}"/></td>
				</tr>
				<tr>
					<td>PHONE NUMBER</td>
					<td><input type="text" name="mem_phonenum" value="${m.mem_phonenum}"/></td>
				</tr>
				<tr>
					<td>REPRESENTATIVE NAME</td>
					<td><input type="text" name="repname" value="${m.repname}"/></td>
				</tr>
				<tr>
					<td>REPRESENTATIVE IC NUMBER</td>
					<td><input type="text" name="repnum" value="${m.repnum}"/></td>
				</tr>
				<tr>
					<td><input type="hidden" name="memberid" value="<c:out value="${m.memberid}"/>"/><br><br></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Submit"/>
		<input type="reset" value="Reset"/>
	</form>
	
	<h1>CHANGE PASSWORD</h1>
	<form action="ManageProfileMemberController?action=change_pass" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<p>CURRENT PASSWORD</p>
					</td>
					<td>
						<input type="password" id="current_pass" name="current_pass">
					</td>
				</tr>
				<tr>
					<td>
						<p>ENTER NEW PASSWORD</p>
					</td>
					<td>
						<input type="password" id="new_pass" name="new_pass">
					</td>
				</tr>
				<tr>
					<td>
						<p>RE-ENTER NEW PASSWORD</p>
					</td>
					<td>
						<input type="password" id="confirm_pass" name="confirm_pass">
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" onclick="showPass()">Show Password
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Submit"/>
	</form>
	
	<script>
      function showPass() {
    	  var x = document.getElementById("current_pass");
    	  var y = document.getElementById("new_pass");
    	  var z = document.getElementById("confirm_pass");
    	  if (x.type === "password") {
    	    x.type = "text";
    	  } 
    	  else {
    	    x.type = "password";
    	  }

    	  if (y.type === "password") {
    	    y.type = "text";
    	  } 
    	  else {
    	    y.type = "password";
    	  }

    	  if (z.type === "password") {
    	    z.type = "text";
    	  } 
    	  else {
    	    z.type = "password";
    	  }
    	}
      
      var check = function() {
    	  if (document.getElementById('new_pass').value == document.getElementById('confirm_pass').value) {
    	    document.getElementById("sub").disabled = false;
    	  } 
    	  else {
    	    document.getElementById("sub").disabled = true;
    	  }
    	}
      
      </script>
        <footer class="footer bg-theme"><p class="m-0 text-center text-white"><b>Copyright &copy; E-Khairat 2022</b></p></footer>
</body>
</html>