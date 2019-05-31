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

	<%
		if (request.getAttribute("NoBook") != null) {
	%>
	<h1><%=request.getAttribute("NoBook")%></h1>

	<%
		request.setAttribute("NoBook", null);
		}
	%>

	<br>
	<h1 style="color: red; size: 500px;">
		<b>Please select the book you want to issue</b>
	</h1>
	<hr color="aqua">

	<br>
	<br>

	<form action="issuebk" style="background-color: aqua; color: navy;">
		<font size="6">Book Name :</font> <input name="bookname" list="books"
			placeholder="Book Name">
		<datalist id="books">
			<option value="Quantum Computer">
			<option value="SQL">
		</datalist>
		<br> <br> <font size="6">Click to check if the
			queried book is available or not : </font>
		<button type="submit" style="font-size: small;">Check</button>
		<br> <br> <font size="6">Click to if you want to
			logout </font><a href="FrontPage.html"><button style="font-size: small;">Logout</button></a>
	</form>

</body>
</html>