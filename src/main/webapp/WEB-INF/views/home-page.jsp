<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<script src="/assets/js/test.js"></script>
 
<meta charset="ISO-8859-1">

<!-- put static resources like css files and js files into resourses folder -->


<title>Insert title here</title>

	<style>
.nav {
	text-align: right;
	font-size: 18px;
}

.h-head {
	text-align: center;
	font-size: 18px;
}

.form-cont {
	text-align: center;
	margin-top: 20px;
}

.form-subcont {
	margin-bottom: 30px;
}

.blue-btn {
	width: 75px;
	height: 50px;
	background-color: #547ceb;
	color: white;
	outline: none;
	border: none;
}

.error {
	color: red;
	font-size: 14px;
	margin-left:10px;
	position:fixed;
	text-align:left;
}

.term-error{
	margin-top:5px;
}

</style>


</head>
<body>



	<div class="nav">
		<a href="">logout</a>
	</div>
	
	
	<div class= "h-head" > The Love Calculator</div>
	
	<hr>

<!-- use the form tag to submit form and move to another page, use action attribute to move the data you set for name="inputs" to another page on server, use method attribute to submit form with get or post  -->

	<form:form id="form" action="results" method="get" modelAttribute="loveDto" onSubmit="return validForm()">
		<div class="form-cont">
			<div class="form-subcont"> 
				<label for="yournameinput">Your Name: </label> 
				<form:input id="yournameinput" path="yourName"/>          <!-- use name attribute to give an input box a parameter name, when you submit, you will see parameter names in URL-->
				
				<!-- tag displays error message from @NotBlank annotation-->
				<form:errors class="error" path="yourName"/>
			</div>	
			<div class="form-subcont">
				<label for="crushnameinput">Crush Name: </label> 
				<form:input id="crushnameinput" path="crushName"/>
				<form:errors class="error" path="crushName"/>
			</div>
			<div class="form-subcont">
				<label>Number of attempts: </label>
				<form:input id="failedTimesInput" path="failedTimes"/> 
				<form:errors class="error" path="failedTimes"/>
			</div>
\
		
			<div class="form-subcont">
				<form:checkbox id="agreebox" path="agreement"/>
				<label>I agree this is only for fun!</label>
				<form:errors class="error term-error" path="agreement"/> 
			</div>
			
			
			
			
			<button id="submitbutton" class="blue-btn">Calculate</button>
		</div>
	</form:form>
	
	<script>
	
		
		//takes inputs of form, tests if they're non empty, if empty return false
		function validForm(){
		
			//get name input
			var name = yournameinput.value; 
			
			//get crushname input
			var crushname = crushnameinput.value; 
			
			//if all inputs are greater then length 0 return false
			if(name.length > 0 && crushname.length>0){
				return true; 
			}
			
			//otherwise return false and display warning messages in an alert
			else{
				
				//display warning messages corresponding to the fields
				if(name.length < 1 && crushname.length!=0){
					alert("your name needs at least 1 char"); 
				}
				else if(crushname.length < 1 && name.length!=0){
					alert("your crush name needs at least 1 char");
				}
				else{
					alert("incomplete fields");
				}
				
				return false; 

				}
				
			//if the button is checked make sure user goes to the next page
			if(agreebox.checked == false){
			alert("You must agree to the terms"); 
		}
		
		};
		
		
		
	
	</script>
	
	<script>
	
		//failed times client validation
		if(failedTimesInput.value < 0{
			alert("Surely, you must have failed more then once...");
		}
	
	</script>
	

</body>
</html>