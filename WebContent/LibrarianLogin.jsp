<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Login Page</title>
<link href="LibrarianLogin.css" rel="stylesheet">
</head>
<body>

	<span id="span1" style="height: 100;align-content: center;">
		<font size="5" face="arial"><h1 align="center" style="">Welcome, Please enter credentials</h1></font>
	</span>

	<span id="image" > <img src="images/Librarian.jpeg"
		height="250" align="top" border="4" >
	</span>
	<br>
	<br>
	

	<br>
	<br>

	<form name="Librarian" action="Librarian">
	<font size="5" color="navy"><h3>All Fields are mandatory</h3></font>
		<table>
			<tr>
				Enter Librarian Id :
				<input type="text" name="librarianid">
			</tr>
			<br>
			<br>
			<tr>
				Enter Librarian Password :
				<input type="password" name="librarianpassword">
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