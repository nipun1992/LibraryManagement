<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Login Page</title>
<link href="cssCreateUser.css" rel="stylesheet">
</head>
<body>

	<span style="width: 800; height: 100;">
		<h2 style="color: red;">Welcome respected Librarian, please enter
			credentials :</h2>
	</span>


	<span id="image"> <img alt="" src="images/Student.jpg"
		height="250" align="top" border="4">
	</span>
	<br>
	<br>
	<h4>Fields marked in asterisk are mandatory</h4>

	<br>
	<br>

	<form name="Librarian" action="Librarian" style="background-color: aqua; color: navy;">
		<table>
			<tr>
				Enter Librarian Id* :
				<input type="text" name="librarianid">
			</tr>
			<br>
			<br>
			<tr>
				Enter Librarian Password* :
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