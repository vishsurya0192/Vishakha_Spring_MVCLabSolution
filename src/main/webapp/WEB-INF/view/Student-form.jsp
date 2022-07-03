<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
<form action="/StudentManagement/student/save" method="POST">
	<input type="hidden" name="id" value="${Student.id}" /><br>
	<input type="text" name="name" value="${Student.name}" /><br>
	<input type="text" name="department" value="${Student.department}" /><br>
	<input type="text" name="country" value="${Student.country}" /><br>
	<button type="submit">Save</button>
</form>
<a href="/StudentManagement/student/list">Back to Students List</a>
</body>
</html>