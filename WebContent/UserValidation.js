function validate() {

	name = NewUser.fullname.value;

	if (name == "" || name.length == 0) {
		alert("Name Not entered");
		return false;
	}

	var uid = NewUser.userid.value;
	var bool = false;

	if (uid == "" || uid.length == 0) {
		alert("UserId Not entered");
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

		if (pswd == "" || pswd.length == 0) {
			alert("Password Not entered");
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
		var sem = NewUser.sem.selectedIndex;

		if (!(sem >= 1 && sem <= 8)) {
			alert('Select semester between 1 and 8');
			return false;
		}

	}

	var branch = NewUser.branch.selectedIndex;

	if (branch == "----") {
		alert('Select branch');
		return false;
	} else {

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
	} else if (mobile.length < 10) {
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