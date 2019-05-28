<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color: olive; font-size: xx-large;">Review
		Entered Data</h1>

	<form action="">

		<table>
			<tr>
				Full Name :
				<%=request.getParameter("fullname")%>">
			</tr>
			<br>
			<br>
			<tr>
				UserId :<%=request.getParameter("userid")%>">
			</tr>
			<br>
			<br>
			<tr>
				Password :
				<%=request.getParameter("password")%>">
			</tr>
			<br>
			<br>
			<tr>
				Semester :
				<%=request.getParameter("sem")%>">
			</tr>
			<br>
			<br>
			<tr>
				Stream :
				<%=request.getParameter("branch")%>">
			</tr>
			<br>
			<br>
			<tr>
				Gender :
				<%=request.getParameter("r1")%>
			</tr>
			<br>
			<br>
			<tr>
				Age :
				<%=request.getParameter("age")%>
			</tr>
			<br>
			<br>
			<tr>Mobile :
			</tr>
			<br>
			<br>
			<tr>Email :
			</tr>
			<br>
			<br>
			<tr>
				Photo :
				<input type="file" name="im">
			</tr>
			<br>
			<br>
			<tr>State :
			</tr>
			<br>
			<br>
			<span>
				<tr>
					Click to register :
					<input type="submit" value="Register">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Clear
					the fields :
					<input type="reset" value="Reset">
				</tr>
			</span>
		</table>


	</form>


</body>
</html>