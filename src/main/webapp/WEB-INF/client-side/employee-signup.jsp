<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MaharjanWorks | Signup</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<header class="header">
	<h1 class="header-title">MAHARJAN <span class="text-primary">WORKS</span></h1>
	<div class="navbar">
		<a href="signup">Signup</a>
		<a href="index">Home</a>
	</div>
</header>

<div class="container"> 
	<form action="/signupEmployee" method="post" enctype="multipart/form-data" class="form-signup">
		<h2 class="form-title">Let's Join </h2>
		
		 <p class="message-alert">${message}</p>
		 
		<div class="form-group">
			<label for="firstName" class="form-label">*First Name:</label>
			<input type="text" name="firstName" id="firstName" placeholder="Enter First Name" class="form-input" required>
		</div>
		<div class="form-group">
			<label for="lastName" class="form-label">*Last Name:</label>
			<input type="text" name="lastName" id="lastName" placeholder="Enter Last Name" class="form-input">
		</div>
		<div class="form-group">
			<label for="email" class="form-label">*Email:</label>
			<input type="email" name="email" id="email" placeholder="Enter Email" class="form-input">
		</div>
		<div class="form-group">
			<label for="password" class="form-label">*Password:</label>
			<input type="password" name="password" id="password" placeholder="Enter password" class="form-input">
		</div>
			<div class="form-group">
			<label for="profileImage" class="form-label">*Profile Image:</label>
			<input type="file" name="profileImage" id="profileImage" accept="image/*" class="form-input">
		</div>
		
		<div class="form-btn">
			<input type="submit" value="Signup" class="btn-submit">
			<input type="reset" value="Reset" class = "btn-reset">
		</div>
		
		<p class="message-info">if you have signup already,<br>
		click on <a href="loginEmployee"  style="color:yellow; text-decoration:none;"><span>login</span></a></p>
		
	</form>



</div>

  <footer>
  	<p>Copright &copy;2024</p>
  </footer>

</body>
</html>