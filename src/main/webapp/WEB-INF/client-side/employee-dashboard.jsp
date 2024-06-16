<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MaharjanWorks | Dashboard</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>


<header class="header">
	<h1 class="header-title">MAHARJAN<span class="text-primary">WORKS</span></h1>
	<div class="navbar">
		<a href="signupEmployee">Signup</a>
		<a href="index">Home</a>
	</div>
</header>

<div class="container"> 
<form class="form-dashboard">
     	<h2 class="form-title"> Dashboard</h2>
		<table>
	
			<tr>
				<td>Employee Id: </td><td><input type="text" name="employeeId" value="${dto.employeeId}" readonly class="dashboard-id"></td>
			</tr>
			
			<tr>
				<td>Employee Name: </td><td>${dto.firstName} ${dto.lastName}</td>
			</tr>
			
			<tr >
					<td>Email:</td>  <td>${dto.email}</td>
			</tr>
			<tr>
					<td>Password:</td> <td>${dto.password}</td>
			</tr>
			<tr>
				<td>Profile Image:</td> <td><img src="data:image/*;Base64,${profileImage}" class="profile-image"></td>
			<tr>
		
		</table> 



			<div class="btn-container">
				<a href="findEmployeeById" class="btn btn-signup">Search Employee</a> 
				<a href="updateEmployee" class="btn btn-signup">Update Employee</a> 
				<a href="viewAll" class="btn btn-signup">View All Employee</a>
			</div>
		</form>
</div>

  <footer>
  	<p>Copright &copy;2024</p>
  </footer>



</body>
</html>