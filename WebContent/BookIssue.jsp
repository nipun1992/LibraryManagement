<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">


	<%-- <center>
		<font size="7" color="#4150f4"><b><%=request.getAttribute("NoBook")%></b></font>
	</center> --%>



	<br>
	<h1 style="color: red; size: 500px;">
		<b>Please select the book you want to issue</b>
	</h1>
	<hr color="aqua">

	<br>
	<br>

	<form action="issuebk" style="background-color: aqua; color: navy;">
		Book : <input name="bookname" list="books">
		<datalist id="books">
			<option value="Quantum Computer">
			<option value="SQL">
		</datalist>
		<br> <br> Click to check if the queried book is available or
		not : <input type="submit" value="Check">
	</form>

</body>
</html>