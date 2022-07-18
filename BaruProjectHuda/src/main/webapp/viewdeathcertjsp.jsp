<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Death Certificate</title>
</head>
<body>
	<a href="ListClaimController">LIST OF APPLICATION CLAIM</a><br><br>
	<h2>Death Certificate</h2>
	Payment ID: <c:out value="${c.applicationid}"/> <br>
	<iframe src="deathcertificateimg/<c:out value="${c.deathcertificate}"/>" width="100%" height="500px"></iframe>
</body>
</html>