<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
			.nav {
				text-align: right;
				font-size: 18px;
			}
			
			.resultscontainer{
				text-align:center;
			}
			
			.resultscontainer> div{
				
			}
</style>


</head>
<body>

		<div class="nav">
			<a href="">logout</a>
			<hr>
		</div>
		
		
		<div id="resultscontainer" class="resultscontainer">
			<div>
				<label>The Love Calculator predicts: </label>
			 </div>
			 
			 <br>
			 
			 <div>
				<label>${loveDto.yourName} and ${loveDto.crushName} are: </label>
			 </div>
			 <br>
			<div>
				<label>${"friends"}</label> <!-- output of our service layer-->
			</div>
			 
		 </div>

	
		<div id="linkcontainer" class="linkcontainer">
			<div>
			`	<!--URL for next page-->
				<a href="/SpringMVCZLoveCalc/sendemail">send result to email</a> <!-- need application context root, right click > properties >  web project settings -->
				<!--To get context root dynamically use /${pageCOntext.request.contextPath/myURL}-->
			</div>
			<div>
				<a href="">try with somebody else</a>
			</div>
			<div>
				<a href="">check user history</a>
			</div>
		</div>
	


</body>
</html>