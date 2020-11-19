<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ page isELIgnored="false" %>
</head>
<body>
	
	<!-- name of variable not class name-->
	<div>Credit Number: ${BillDto.creditCard}</div>
	<div> Amount:  ${BillDto.amount} ${BillDto.currency.getDisplayName()}</div> <!-- can print currency object which is currency code or just get displayname -->
	<div>Date: ${BillDto.date} </div>

</body>
</html>