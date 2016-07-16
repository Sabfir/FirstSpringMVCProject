<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/FirstSpringMVCProject/login.html?siteLanguage=en">English</a>
	 | 
	<a href="/FirstSpringMVCProject/login.html?siteLanguage=it">Italian</a>
	
	<h1>${topmessage}</h1>
	<h1>Log in</h1>
	
	<form:errors path="student.*" />
	
	<form action="/FirstSpringMVCProject/submitLoginUsingModelAttribute" method="post">
		<table>
			<tr>
				<td><spring:message code="label.student_name" /></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.student_dob" /></td>
				<td><input type="text" name="DOB" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.student_iq" /></td>
				<td><input type="text" name="IQ" /></td>
			</tr>
			<tr>
				<td>Student's hobbies: </td>
				<td>
					<select name="hobbies" multiple="multiple">
						<option value="music">Music</option>
						<option value="calcio">Football</option>
						<option value="traveling">Traveling</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Address</td>
			</tr>
			<tr>
				<td>Country: </td>
				<td><input type="text" name="address.country"/>
				<td>City</td>
				<td><input type="text" name="address.city"/>
			</tr>
			<tr>
				<td><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>