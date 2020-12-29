<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
			.nav {
				text-align: right;
				font-size: 18px;
			}
			
			.emailcontainer{
				text-align:center;
			}
		
			
			.error {
				color: red;
				font-size: 14px;
				margin-left: 10px;
				position: fixed;
				text-align: left;
			}
					
			
</style>

<%@ page isELIgnored="false" %>

</head>
<body>

		<!-- IMPORTANT NOTE: the action attribute takes a string URL of location to send, not the page name  -->

		<div class="nav">
			<a href="">logout</a>
			<hr>
		</div>
		
		
		<div id="emailcontainer" class="emailcontainer">

		<!-- section to display cookies and sessions -->
		<div>

			<h3>Hi ${loveDto.yourName},</h3>
			<label>type in an email and send the results to your crush:</label>

		</div>
		<br>
		
		<!-- action takes in URL, modelAttribute is model attribute name in annotation-->
		<form:form action="processemail" modelAttribute="emailDto" method="GET" >
				<div>
					<form:input id="emailinput" path="email"></form:input>
					<button> Send </button>
					<form:errors class="error" path="email"></form:errors>
				 </div>
			 </form:form>
		 </div>

	
		<div id="linkcontainer" class="linkcontainer">
		
			<div>
				<a href="">try with somebody else</a>
			</div>
			<div>
				<a href="">check user history</a>
			</div>
		</div>
	


</body>
</html>