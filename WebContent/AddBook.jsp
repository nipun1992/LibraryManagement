<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>

	<center>
		<div style="background-color: maroon;">
			<font color="red"
				style="font-family: cursive; font-size: xx-large; font-style: italic; font-weight: bolder; background-color: aqua;">Add
				Book to the Library</font>

		</div>

		<span id="image" style="width: 1200; background-color: olive;">
			<img alt="" src="images/Book.jpeg" height="250" align="top"
			border="4">
		</span>
	</center>
	<br>
	<br>
	<h4>Fields marked in asterisk are mandatory</h4>

	<br>
	<br>

	<form name="NewBook" action="addbook" method="post"
		style="background-color: aqua; color: navy;">
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
