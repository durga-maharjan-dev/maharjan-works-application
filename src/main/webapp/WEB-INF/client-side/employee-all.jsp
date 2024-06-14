<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kubeiko | All Employee</title>
</head>
<body>

<table>
<thead>
		<tr>
				<th>Employee Id</th>
				<th>First Name </th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Password</th>
				<th> Profile Image</th>		
			</tr>
		</thead>

<c:forEach items= "${dtos}" var="dto">
<tr>
	<td>${dto.employeeId }</td>
	<td>${dto.firstName }</td>
	<td>${dto.lastName }</td>
	<td>${dto.email }</td>
	<td>${dto.password }</td>
	<td><img src="data:image/jpeg;Base64,${dto.profileImage}" width="240" height="300"/></td>

</tr>

</c:forEach>
</table>
</body>
</html>