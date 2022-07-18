<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Receipt</title>
</head>
<body>

	<a href="ListPaymentController">List of Payment</a><br><br>
	<h2>Online Payment Receipt</h2>
	Payment ID: <c:out value="${p.paymentid}"/> <br>
	<iframe src="receiptimg/<c:out value="${p.payment_receipt}"/>" width="100%" height="500px"></iframe>

</body>
</html>