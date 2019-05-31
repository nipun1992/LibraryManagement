<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>

<script type="text/javascript">

function bookSubmission()
{

var name = NewBook.bookname.value;

//document.write("<h1>Name of book is " + name + "</h1>");

if(name.trim() == "")
{
	alert('Book name not provided');
	return false;
}

var bkId = NewBook.bookid.value;

if(bkId.trim() == "")
{
	alert('Book Id not provided');
	return false;
}

}
</script>

</head>
<body bgcolor="green">

	<center>
		<div style="background-color: maroon;">
			<font color="red"
				style="font-family: cursive; font-size: xx-large; font-style: italic; font-weight: bolder; background-color: aqua;">Add
				Book to the Library</font>

		</div>

		<span id="image"
			style="width: 1200; background-color: olive; background-repeat: round;">
			<img alt="" src="images/Book.jpeg" height="250" align="top"
			border="4">
		</span>
	</center>
	<br>
	<br>
	<h4
		style="color: purple; font-size: x-large; background-color: scrollbar;">Fields
		marked in asterisk are mandatory</h4>

	<br>
	<br>

	<form name="NewBook" action="addbook" method="post"
		style="background-color: aqua; color: navy;" onsubmit="return bookSubmission();">
		<table>
			<tr>
				Enter Book Name* :
				<input type="text" name="bookname">
			</tr>
			<br>
			<br>
			<tr>
				Enter Book Id* :
				<input type="text" name="bookid">
				<br>
				(Book Id must have 4 characters)
			</tr>
			<br>
			<br>
			<tr>
				Enter Stream :
				<input name="streams" list="stream">
				<datalist id="stream">
					<option value="Computer Science">
					<option value="Electronics and Communication">
					<option value="Mechanical">
					<option value="Electrical">
					<option value="Civil">
				</datalist>
			</tr>
			<br>
			<br>
			<tr>
				<br>
				<br>
			<tr>
				Enter author :
				<input type="text" name="bookauthor">
				<br>
			</tr>
			<br>
			<br>
			<br>
			<br>
			<tr>
				Insert Ebook file :
				<input type="file" name="bookfile">
				<br>
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
>
