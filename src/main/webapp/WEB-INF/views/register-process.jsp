<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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

	<!-- Assigning java object to javascript variable -->
	<script>
		
	
	</script>

	
	<div>my name is: ${RegisterDto.name}</div>
	<div>my username is: ${RegisterDto.username}</div>
	<div>my password is: ${RegisterDto.password}</div>
	<div>my country is: ${RegisterDto.country}</div>
	<div>my hobbies are:
	
		<!--  the for each tag loops every item from the array, stores into temp variable, then 
		we can interpolate temp variable-->
		<c:forEach var="temp" items="${RegisterDto.hobbies}">
			${temp}
		</c:forEach>
	</div>
	<div>my age is: ${RegisterDto.age}</div>
	<div>my gender is: ${RegisterDto.gender}</div>
	<div>email: ${RegisterDto.commDto.email}</div>
	<div>phone: ${RegisterDto.commDto.phone.toString()}</div>
	

	
	<div id="currentpageaddress"></div>
	<script>
	
		//display the URL into the div
		currentpageaddress.innerHTML = "Current URL is: " + window.location.href; 
	
	</script>
	


</body>
</html>