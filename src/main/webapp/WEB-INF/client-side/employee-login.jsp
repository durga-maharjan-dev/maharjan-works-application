<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Junit | Login</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<header class="header">
	<h1 class="header-title">MAHARJAN <span class="text-primary">WORKS</span></h1>
	<div class="navbar">
		<a href="signupEmployee">Signup</a>
		<a href="index">Home</a>
	</div>
</header>

<div class="container"> 
	<form action="loginEmployee" method="post"  class="form-signup form-login">
		<h2 class="form-title">Let's Go To Dashboard </h2>
		
		 <p class="message-info">${message}</p>
		 
	
		<div class="form-group">
			<label for="email" class="form-label">*Email:</label>
			<input type="email" name="email" id="email" placeholder="Enter Email" class="form-input">
		</div>
		<div class="form-group">
			<label for="password" class="form-label">*Password:</label>
			<input type="password" name="password" id="password" placeholder="Enter password" class="form-input">
		</div>
		
		<div class="form-btn">
			<input type="submit" value="Login" class="btn-submit">
		</div>
	
		
	</form>



</div>

  <footer>
  	<p>Copright &copy;2024</p>
  </footer>

</body>
</html>

