<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link href="CSSFiles/cssCreateUser.css" rel="stylesheet">
<!-- <script src="./JSFiles/UserValidation.js"></script> -->
<script type="text/javascript">
	function validate() {

		name = NewUser.fullname.value;

		//if (name == "" || name.length == 0) {
		if (name == "") {
			alert("Name Not entered. Please provide name");
			return false;
		}

		var uid = NewUser.userid.value;
		var bool = false;

		//if (uid == "" || uid.length == 0) {
		if (uid == "") {
			alert("UserId Not entered. Please provide user id");
			return false;
		} else if (uid.length < 4) {
			alert("UserId must have 4 characters");
			return false;
		}

		i = 0;

		for (i = 0; i < uid.length; i++) {
			if (uid.charAt(i) == uid.charAt(i).toUpperCase()) {
				bool = true;
			}
		}

		if (bool == false) {
			alert('At least 1 upper case character required in user id');
			return false;
		} else {
			var pswd = NewUser.password.value;

			//if (pswd == "" || pswd.length == 0) {
			if (pswd == "") {
				alert("Password Not entered. Please provide password");
				return false;
			} else if (pswd.length < 4) {
				alert("Password must have 4 characters");
				return false;
			}

			bool = false;

			for (i = 0; i < pswd.length; i++) {
				if ((pswd.charAt(i) == pswd.charAt(i).toUpperCase())) {
					bool = true;
				}
			}
		}

		if (bool == false) {
			alert('At least 1 upper case character required in password');
			return false;
		} else {
			var semester = NewUser.sem.selectedIndex;

			if (!(semester >= 1 && semester <= 8)) {
				alert('Select semester between 1 and 8');
				return false;
			}

		}

		//var stream = NewUser.branch.selectedIndex;

		// document.write("<h1>" + branch + "</h1>")

		//var stream = document.getElementsByClassName("branch").selectedIndex;
		var stream = NewUser.branch.selectedIndex;
		/*
		 * var branch = NewUser.branch.selectedIndex; // var branch =
		 * document.getElementById("subject").value; document.write("<h1>" + sem + "</h1>");
		 * document.write("<h1>" + branch + "</h1>");
		 */

		// var branch = document.getElementById("subject").value;
		/*
		 * if (!(branch == "Computer Science" || branch == "Electronics and
		 * Communication" || branch == "Mechanical" || branch == "Electrical" ||
		 * branch == "Civil")) {
		 */

		// if (document.getElementById('subject').value == "----") {
		if (stream == "----") {
			alert('Select branch');
			return false;
		}

		var gender = NewUser.r1.value;
		if (gender == "") {
			alert('Select Gender');
			return false;
		}

		var age = NewUser.age.value;
		if (age == "") {
			alert('Enter Age');
			return false;
		}

		var mobile = NewUser.num.value;
		if (mobile == "") {
			alert('Enter Mobile number');
			return false;
		} else if (mobile.length != 10) {
			alert('Mobile number should have 10 digits');
			return false;
		}

		var email = NewUser.eml.value;

		if (email == "") {
			alert('Enter email address');
			return false;
		}

		bool = false;

		for (i = 0; i < email.length; i++) {
			if (email.charAt(i) == '@') {
				bool = true;
			}
		}

		if (bool == false) {
			alert('Provide valid email address');
			return false;
		}

	}
</script>

</head>
<body>

	<br>

	<span style="width: 800; height: 100;">
		<h2 style="color: red;">To apply for Library account, please fill
			up the below fields :</h2>
	</span>


	<span id="image" style="width: 390;"> <img alt=""
		src="images/Student.jpg" height="250" align="top" border="4">
	</span>
	<br>
	<br>
	<h4>Fields marked in asterisk are mandatory</h4>

	<br>
	<br>

	<form name="NewUser" action="user" method="post"
		onsubmit="return validate();"
		style="background-color: aqua; color: navy;">
		<table>
			<tr>
				Enter your Full Name* :
				<input type="text" name="fullname" placeholder="Full Name"
					autocomplete="off">
			</tr>
			<br>
			<br>
			<tr>
				Enter your UserId* :
				<input type="text" name="userid" placeholder="User Id"
					autocomplete="off">
				<br> (UserId must have 4 characters with at least 1 upper case
				character)
			</tr>
			<br>
			<br>
			<tr>
				Enter your Password* :
				<input type="password" name="password" placeholder="Password">
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
				<input type="number" name="age" placeholder="Age">
			</tr>
			<br>
			<br>
			<tr>
				Mobile* :
				<input type="number" name="num" placeholder="Mobile no."
					autocomplete="off">
			</tr>
			<br>
			<br>
			<tr>
				Email* :
				<input type="email" name="eml" placeholder="Email address"
					autocomplete="off">
			</tr>
			<br>
			<br>
			<tr>
				Photo :
				<input id="img1" type="file" name="im" placeholder="Photo"
					autocomplete="off">

			</tr>
			<br>
			<br>
			<tr>
				State :
				<input name="state" list="states" placeholder="Where are you from?"
					autocomplete="off">
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