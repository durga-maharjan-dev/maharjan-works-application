<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="maharjanworks.dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MaharjanWorks | All Employee</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<header class="header">
	<h1 class="header-title">MAHARJAN <span class="text-primary">WORKS</span></h1>
	<div class="navbar">
		<a href="signupEmployee">Signup</a>
		<a href="loginEmployee">Login</a>
	</div>
</header>

<%
	List<EmployeeDTO> dtoList=(ArrayList<EmployeeDTO>)request.getAttribute("dtoList");
%>

<div class="container container-view-all">
<table>
	<h2 class="table-title">All Enrolled Employees</h2>
	<thead>
		<tr>
				<th>Employee Id</th>
				<th>First Name </th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Profile Image</th>		
			</tr>
	</thead>
		<%
		for(EmployeeDTO dto: dtoList){
		%>
		<tr>
			<td><%=dto.getEmployeeId()%></td>
			<td><%=dto.getFirstName()%></td>
			<td><%=dto.getLastName()%></td>
			<td><%=dto.getEmail()%></td>
			<td><%=dto.getPassword()%></td>
			<%
			  String profileImage = Base64.getEncoder().encodeToString(dto.getProfileImage());
			%>
			<td><img src="data:image/*;Base64,<%=profileImage%>" width="50" height="60px"/></td>
		</tr>
		<%
		}
		%>
</table>
</div>

  <footer>
  	<p>Copright &copy;2024</p>
  </footer>
  
</body>
</html>