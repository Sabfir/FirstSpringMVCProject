<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${topmessage}</h1>
	<h1>First Spring MVC App Demo</h1>
	<table >
		<tr>
			<td>Student's name</td>
			<td>${student.name}</td>
		</tr>
		<tr>
			<td>Student's DOB</td>
			<td>${student.DOB}</td>
		</tr>
		<tr>
			<td>Student's IQ</td>
			<td>${student.IQ}</td>
		</tr>
		<tr>
			<td>Student's hobbies: </td>
			<td>${student.hobbies}</td>
		</tr>
		<tr>
			<td>Student's address: </td>
		</tr>
		<tr>
			<td>Country: </td>
			<td>${student.address.country}</td>
			<td>City: </td>
			<td>${student.address.city}</td>
		</tr>
	</table>
</body>
</html>