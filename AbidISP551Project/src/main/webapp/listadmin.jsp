<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%//prevent Caching of JSP Pages
 response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
//get session and check if session null, go to login page
if(session.getAttribute("currentSessionUser")==null)
	response.sendRedirect("index.html");%>
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

button{
  background-color:#6b9bd1;
  border: none;
  color: white;
  padding: 10px 30px;
  text-decoration: none;
  margin: auto;
  cursor: pointer;
  text-align:center;

}

/*form{
  position: absolute;
  top: 50%;
  left: 50%;
  width: auto;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: white;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
  font-family: verdana;
   font-size: 20px;

}*/
h1{
   text-align: center;
}

.col-span-25{
	float:left;
	width:25%;
	margin-top:6px;
}

.col-span-75{
	float:left;
	width:75%;
	margin-top:6px;
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
<title>List Admin</title>
</head>
<body>
 <!-- Responsive navbar-->
        <div class="nav">
              <input type="checkbox" id="nav-check">
              <div class="nav-header">
                <div class="nav-title d-flex align-items-center">
                  <p class="mb-brand">Create Admin</p>
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
                <a href="ManageProfileSupervisorController">Manage Profile</a>  
                <a href="createadmin.jsp">Register New Admin</a><br>
                <a href= "ListAdminController">List Of Admin</a>
                <a href="LogoutAdminController">Logout</a> 
                <a href= "ViewSupervisorController">Back</a>
                <a></a>
                <a></a>
              </div>
        </div>
		<table border="1">
			<tr>
				<th>Admin ID</th>
				<th> Name</th>
				<th> IC Number</th>
				<th> Email </th>
				<th> Age</th>
				<th>Phone Number</th>
				<th>Supervisor ID</th>
				<th>Password</th>
				<th colspan="8">Action</th>
			</tr>
			<c:forEach items ="${admin}" var="a" varStatus="admin">
			<tr>
				<td><c:out value="${a.adminid}" /></td>
				<td><c:out value="${a.add_name}" /></td>
				<td><c:out value="${a.admin_icnum}" /></td>
				
				<td><c:out value="${a.add_email}" /></td>
				<td><c:out value="${a.add_age}" /></td>
				<td><c:out value="${a.add_phonenum}" /></td>
				
			    <td><c:out value="${a.supervisorid}" /></td>
			    <td><c:out value="${a.add_password}" /></td>
			   
				<td><a class=" btn-view" href="ViewAdminController?adminid=<c:out value="${a.adminid}"/>">View</a></td>
				<td><a class=" btn-update" href="UpdateAdminController?adminid=<c:out value="${a.adminid}"/>">Update</a></td>
				<td><a class=" btn-delete" href="DeleteAdminController?adminid=<c:out value="${a.adminid}"/>">Delete</a></td>
				
			</tr>
			</c:forEach>
		</table>
		
		<!-- <script>
		function confirmation(id) {
			console.log(id);
			var r = confirm("Are you sure you want to delete?");
			if (r == true) {
				location.href = 'deletemembercontroller?memberid=' + id;
				alert("Member successfully deleted");
			} else {
				return false;
			}
		}
		</script> -->	
	
</body>
<footer class="footer bg-theme"><p class="m-0 text-center text-white"><b>Copyright &copy; E-Khairat 2022</b></p></footer>
</html>