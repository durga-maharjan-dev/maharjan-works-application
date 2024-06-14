<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kubeiko | Search By Id</title>
</head>
<body>

	<h1>Find Employee ID</h1>
	${message}
	<form action="findEmployeeById" method="post">
		<input type="text" name="employeeId">
		<input type="submit" value="Find"> 
	</form>
	
	<form>
		Employee Id: ${dto.employeeId}
		First Name:  ${dto.firstName}
		Last Name: ${dto.lastName}
		Email:  ${dto.email}
		Password: ${dto.password}
		Profile Image: <img src="data:image/*;Base64,${dto.profileImage}">
		
	</form>

</body>
</html>