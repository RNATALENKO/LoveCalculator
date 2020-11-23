<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

	.nav{
		text-align:right; 
		font-size:18px;
		}
		
		.h-head{
			text-align:center;
			font-size:18px;
			
		}

</style>
<%@ page isELIgnored="false" %>

</head>
<body>


<div class="nav">
		<a href="">logout</a>
	</div>
	
	<div class= "h-head" > The Love Calculator</div>
	
	<hr>
	
	<p>
		Your name is: ${loveDto.yourName} <!--added POJO object to model -->
	</p>
	
	
	<p>
		Your chrush name is: ${loveDto.crushName}
	</p>
	
	<p>
		Number of failed attempts: ${loveDto.failedTimes}
	</p>
	
	

</body>
</html>