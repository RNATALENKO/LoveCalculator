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


	<h1 align="center"> Session Attributes </h1>
	<hr>
	
	<p>${firstName}</p>
	
	<p>${lastName}</p>
	
	<a href="/SpringMVCZLoveCalc/${next}">Next ${next}</a>
	
	<!-- fetch data from request scope model object -->
	<p> firstName fetched from request: ${requestScope.firstName} </p>
	
	<!-- fetch data from session scope object -->
	<p> firstName fetched from session: ${sessionScope.firstName }</p>
	
	<script> 
	
		alert(${firstName});
	</script>


</body>
</html>