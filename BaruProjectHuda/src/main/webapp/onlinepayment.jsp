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


input[type=button], input[type=reset]{
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
<head>
<meta charset="UTF-8">
<title>Online payment</title>
</head>
<body>
 <!-- Responsive navbar-->
        <div class="nav">
              <input type="checkbox" id="nav-check">
              <div class="nav-header">
                <div class="nav-title d-flex align-items-center">
                  <p class="mb-brand">Online Payment</p>
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
                <a href="ManageProfileAdminController">Manage Profile</a>  
                <a href= " paymentmethod">Make Payment</a>  
                <a href = " ">Claim Khairat</a>
                <a href = "index.html ">Log out</a>
                <a></a>  
                <a></a>  

              </div>
        </div>
	<h4>Online payment</h4>
	<h4>Please Bank in into</h4>
	<h4>151601767668</h4>
	<h4>Maybank</h4>
	<h4>Masjid Jamek Gelang Patah</h4>
	<form action="OnlinePaymentController" method="post" enctype="multipart/form-data">
		<table>
			<tbody>
				<tr>
					<th><label>Member ID:</label></th>
                    <th><c:out value="${m.memberid}"/></th>
				</tr>
				<tr>
					<th><label>Name:</label></th>
                    <th><c:out value="${m.mem_name}"/></th>
				</tr>
				<tr>
					<th><label>Ic No:</label></th>
                    <th><c:out value="${m.mem_icnum}"/></th>
				</tr>
				<tr>
					<th><label for="payment_date">Payment Date:</label></th>
                    <th><input id="currentDate" type="date"  name="payment_date"></th>
				</tr>
				<tr>
					<th><label>Payment Amount:</label></th>
					<th>
						<select name="payment_amount">
							<option value="5">Monthly Payment (RM5)</option>
							<option value="60">Yearly Payment (RM60)</option>
						</select>
					</th>
				</tr>
			   	<tr>
					<th><label for="bankname">Bank Name:</label></th>
					<th><input type="text"  name="bankname"></th>
				</tr>
				
				<tr>
					<th><label for="payment_receipt">Transaction receipt:</label></th>
					<th><input type="file" name="payment_receipt" enctype="multipart/form-data"></th>
				</tr>
				
			</tbody>
		</table>
		<input type="submit" value="Submit"/>
		<input type="reset" value="Reset"/>
	</form>
	
	<script>
		//Date purpose
		var date = new Date();
		var currentDate = date.toISOString().slice(0, 10);
		var currentTime = date.getHours() + ':' + date.getMinutes();
		document.getElementById('currentDate').value = currentDate;
	</script>
	<footer class="footer bg-theme"><p class="m-0 text-center text-white"><b>Copyright &copy; E-Khairat 2022</b></p></footer>
	
</body>
</html>