function validateLibrarian() {

	var libuser = Librarian.librarianid.value;

	if (libuser != "College") {
		alert("User id is wrong");
		return false;
	}

	var paswrd = Librarian.librarianpassword.value;

	if (paswrd != "Library") {
		alert("Password is wrong");
		return false;
	}

}