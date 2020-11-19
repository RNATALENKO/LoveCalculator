<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


	<style>
	
		.headliner{
			text-align: center;
		}
	
		form{
			width: 275px; 
			margin: auto; 
		}
		
		div {
			margin-bottom: 30px;
		}
		
		input, select{
			float: right; 
		}
		
		.error {
				color: red;
				font-size: 14px;
				margin-left: 10px;
				position: fixed;
				text-align: left;
			}
	
	
	</style>


</head>
<body>

	<div class="headliner">
		<h1>Love calculator</h1>
	</div>

	<!-- model attribute is name of the variable passed into annotation @ModelAttribute("BillDto") otherwise it's 
	default variable name  -->
	<form:form id="billform" action="bill-process" method="post" modelAttribute="BillDto">
	
		<div>
			<label>Card: </label>
			<form:input type="text" path="creditCard"></form:input>
			<form:errors path="creditCard" class="error"></form:errors>
		</div>
		
		
		<div>
			<label>Amount:</label>
			<form:input path="amount"></form:input>
			<form:errors path="amount" class="error"></form:errors>
		</div>
		
		
		<div>
			<label>currency:</label>
			
			<form:input path="currency"></form:input>
			<form:errors path="currency" class="error"></form:errors>
			<!-- select options
			<form:select path="currency">
				<option value="USD">USD</option>
				<option value="EUR">EUR</option>
			</form:select>
			
			-->
			
		</div>
		
		
		 
		<div>
			<label>Date:</label>
			<form:input path="date"></form:input>
			<form:errors class="error" path="date"></form:errors>
		</div>
		
		 
		
		<button>Pay bill</button>
		
		 
	</form:form>

</body>
</html>