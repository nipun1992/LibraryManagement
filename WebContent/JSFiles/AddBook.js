function bookSubmission() {

	var name = NewBook.bookname.value;

	if (name.trim() == "") {
		alert('Book name not provided');
		return false;
	}

	var bkId = NewBook.bookid.value;

	if (bkId.length != 4) {
		alert('Book Id must have 4 characters');
		return false;
	}

}