<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Log in</h1>
	
	<form action="/FirstSpringMVCProject/submitLoginUsingModelAttribute" method="post">
		<p>
			Student name: <input type="text" name="name" />
		</p>
		<p>
			Student hobby: <input type="text" name="hobby" />
		</p>
		
		<input type="submit" name="Submit">
	</form>
</body>
</html>