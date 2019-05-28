<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link href="cssCreateUser.css" rel="stylesheet">

<script src="UserValidation.js"></script>

</head>
<body>

	<br>

	<span style="width: 800; height: 100;">
		<h2 style="color: red;">To apply for Library account, please fill
			up the below fields :</h2>
	</span>


	<span id="image"> <img alt="" src="images/Student.jpg"
		height="250" align="top" border="4">
	</span>
	<br>
	<br>
	<h4>Fields marked in asterisk are mandatory</h4>

	<br>
	<br>

	<form name="NewUser" action="user" method="post" onsubmit="validate();"
		style="background-color: aqua;color: navy;">
		<table>
			<tr>
				Enter your Full Name* :
				<input type="text" name="fullname"
					value="<%request.getAttribute("fullname");%>">
			</tr>
			<br>
			<br>
			<tr>
				Enter your UserId* :
				<input type="text" name="userid"
					value="<%session.getAttribute("userid");%>">
				<br> (UserId must have 4 characters with at least 1 upper case
				character)
			</tr>
			<br>
			<br>
			<tr>
				Enter your Password* :
				<input type="password" name="password">
				<br> (Password must have 4 characters with at least 1 upper
				case)
			</tr>
			<br>
			<br>
			<tr>
				Enter your semester* :
				<select name="sem">
					<option>----</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
				</select>
			</tr>
			<br>
			<br>
			<tr>
				Enter your stream* :
				<select name="branch">
					<option>----</option>
					<option>Computer Science</option>
					<option>Electronics and Communication</option>
					<option>Mechanical</option>
					<option>Electrical</option>
					<option>Civil</option>
				</select>
			</tr>
			<br>
			<br>
			<tr>
				Gender* :
				<input type="radio" name="r1" value="M">Male &nbsp;&nbsp;
				<input type="radio" name="r1" value="F">Female
			</tr>
			<br>
			<br>
			<tr>
				Age* :
				<input type="number" name="age">
			</tr>
			<br>
			<br>
			<tr>
				Mobile* :
				<input type="number" name="num">
			</tr>
			<br>
			<br>
			<tr>
				Email* :
				<input type="email" name="eml">
			</tr>
			<br>
			<br>
			<tr>
				Photo :
				<input type="file" name="im">

			</tr>
			<br>
			<br>
			<tr>
				State :
				<input name="state" list="states">
				<datalist id="states">
					<option value="Jammu and Kashmir">
					<option value="Himachal Pradesh">
					<option value="Punjab">
					<option value="Uttarakhand">
					<option value="Delhi">
					<option value="Uttar Pradesh">
					<option value="Bihar">
					<option value="Rajasthan">
					<option value="West Bengal">
					<option value="Madhya Pradesh">
					<option value="Maharashtra">
					<option value="Karnataka">
					<option value="Telengana">
					<option value="Kerela">
					<option value="Tamil Nadu">
					<option value="Goa">
					<option value="Gujarat">
					<option value="Jharkhand">
					<option value="Andhra Pradesh">
					<option value="Orissa">
				</datalist>
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