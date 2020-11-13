<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
			div {
				padding: 5px;
			}
			
			.blue-btn {
				width: 75px;
				height: 50px;
				background-color: #547ceb;
				color: white;
				outline: none;
				border: none;
			}
			
			form {
				width: 300px;
				margin: auto;
			}
			
			nav {
				font-size: 27px;
				text-align: right;
				height: 50px;
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

	<nav>
	
		<a href="#">sign in</a>
	</nav>
		

	

	<form:form action="register-process" method="GET" modelAttribute="RegisterDto">
		<h1>Registration Form</h1>
		<div>
			<label for="nameinput">Name:</label>
			<form:input type="text" id="nameinput" path="name"/>
			<form:errors class="error" path="name"/>
		</div>
		
		<div>
			<label for="usernameinput" >UserName:</label>
			<form:input id="usernameinput" path="username"/>
		</div>
		
		<div>
			<label for="passwordinput">Password:</label>
			<form:password id="passwordinput" path="password"/>
		</div>
		
		<div>
			<label for="countrycombobox">Country:</label>
			<form:select id="countrycombobox"  path="country">
				<option value="United States">US</option>
				<option value="Mexico">Mexico</option>
				<option value="Canada">Canada</option>
			</form:select>
		</div>
		
		<div>
			<label>Hobbies: </label>
			<!--to populate dto array, assign values which will be strings, path leads to hobbiesp[] array-->
			<form:checkbox value="sports" id="sportsbox" path="hobbies"/><label for="sportsbox">sports</label>
			<form:checkbox value = "eating" id="eatingbox" path="hobbies" /><label for="eatingbox">eating</label>
			<form:checkbox value = "drawing" id="drawingbox" path="hobbies" /><label for="drawingbox">drawing</label>
			<form:checkbox value="meditating" id="meditatingbox" path="hobbies"/><label for="meditatingbox">meditating</label>
			<form:checkbox value="reading" id="readingbox" path="hobbies"/><label for="readingbox">reading</label>
		</div>
		
		<div>
			<label> age: </label>
			<form:input path="age"/>
			<form:errors class="error" path="age"/>
		</div>

		<div>
			<label>Gender: </label>
			<form:radiobutton value="male" path="gender" />
			<label>Male</label>
			<form:radiobutton value="female" path="gender" />
			<label>female</label>
		</div>
		<div>
			<label>Email: </label>
			<form:input path="commDto.email"/> <!--path of nested dto should be property name of parent class -->
			<br>
			<label>Phone: </label>
			<form:input path="commDto.phone"/>
			
		</div>
		

		<button type="submit" class="blue-btn" value="register">Submit</button>
		
	</form:form>
	
	

</body>
</html>