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
<head>
<meta charset="UTF-8">
<title>Claim Khairat Application Form</title>
</head>
<body>
	<a href = "ViewMemberController2">BACK</a><br><br>
	<h1>Claim appplication form</h1>
	<form action="CreateClaimController" method="post" enctype="multipart/form-data">
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
					<th><label for="deathcertificate">Upload Death Certificate:</label></th>
					<th><input type="file" name="deathcertificate"></th>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Submit"/>
		<input type="reset" value="Reset"/>
	</form>
</body>
</html>