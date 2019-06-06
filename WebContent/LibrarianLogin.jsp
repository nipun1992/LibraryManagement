<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Login Page</title>
<link href="CSSFiles/LibrarianLogin.css" rel="stylesheet">

<script src="JSFiles/LibrarianLoginValidation.js"></script>

</head>
<body>

	<!-- <span id="span1" style="height: 100; align-content: center;"> <font
		size="5" face="arial"><h1 align="center" style="">Welcome,
				Please enter credentials</h1></font>
	</span> -->
	<span id="span1"> <font size="5" face="arial"><h1
				align="center">Welcome, Please enter credentials</h1></font>
	</span>

	<span id="image"> <img src="images/Librarian.jpeg" height="250"
		align="middle" style="border-color: black; border-style: groove;">
	</span>
	<br>
	<br>


	<br>
	<br>

	<form name="Librarian" action="Librarian"
		onsubmit="return validateLibrarian();">
		<font size="5" color="navy"><h3>All Fields are mandatory</h3></font>
		<table>
			<tr>
				Enter Librarian Id :
				<input type="text" name="librarianid" placeholder="Librarian id"
					autocomplete="off">
			</tr>
			<br>
			<br>
			<tr>
				Enter Librarian Password :
				<input type="password" name="librarianpassword"
					placeholder="Librarian Password">
			</tr>
			<br>
			<br>
			<span>
				<tr>
					Click to register :
					<input type="submit" value="Register">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Clear
					the fields :
					<input type="reset" value="Reset">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</tr>
			</span>
		</table>
	</form>

</body>
</html>