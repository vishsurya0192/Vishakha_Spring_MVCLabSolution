<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Directory</title>
</head>
<body>
<form action="/StudentManagement/student/save" class="form-inline">

<!-- Add a button -->
<a href="/StudentManagement/student/showFormForAdd"
class="btn btn-primary btn-sm mb-3"> Add Student </a> 

</form>
<table>
<thead>
<tr>
<th>id</th>
<th>name</th>
<th>department</th>
<th>country</th>
</tr>
</thead>
<c:forEach items="${Students}" var="tempStudent">
<tr>
	<td><c:out value="${tempStudent.id}"/></td>
	<td><c:out value="${tempStudent.name}"/></td>
	<td><c:out value="${tempStudent.department}"/></td>
	<td><c:out value="${tempStudent.country}"/></td>
	<td>
	<!-- Add"update" button/link -->
	<a href="/StudentManagement/student/showFormForUpdate?studentId=${tempStudent.id}"
	class="btn btn-info btn-sm"> Update</a>
	<a href="/StudentManagement/student/delete?studentId=${tempStudent.id}"
	class="btn btn-danger btn-sm"
	onclick="if(!(confirm('Are you sure you want to delete this Student?'))) return false">
	Delete</a>
	</td>
	</tr>
	
</c:forEach>
</table>
</body>
</html>