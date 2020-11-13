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
	<label>Credit Number: ${BillDto.creditCard.toString()}</label>

</body>
</html>