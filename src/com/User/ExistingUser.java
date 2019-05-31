package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JdbcConnection.Jdbc;

/**
 * Servlet implementation class ExistingUser
 */
//@WebServlet("/ExistingUser")
public class ExistingUser extends HttpServlet {

	Connection con;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExistingUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String usrid = request.getParameter("id1");
		String name = request.getParameter("name1");
		String password = request.getParameter("paswrd1");

		con = Jdbc.connect();

		String sql = "SELECT * FROM LIBRARY_USER WHERE USER_ID = '" + usrid + "' AND NAME = '" + name
				+ "' AND PASSWORD = '" + password + "'";

		try {

			RequestDispatcher rd;

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				System.out.println("User exists");

				rd = request.getRequestDispatcher("BookIssue.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("User does not exist");

				String userDoesNotExist = "Queried user does not exist in the Library system";

				request.setAttribute("userExists", userDoesNotExist);

				rd = request.getRequestDispatcher("ExistingUser.jsp");
				rd.forward(request, response);
				
				/*
				 * response.setContentType("text/html");
				 * 
				 * PrintWriter out = response.getWriter();
				 * 
				 * out.println("<html>"); out.println("<head></head>");
				 * out.println("<body bgcolor=green></body>");
				 * out.println("<font>Not a valid account</font>"); out.println("<br><br>");
				 * out.println("What would like to do now?");
				 * out.println("<font>Try again : <a href=ExistingUser.jsp>Try again</a></font>"
				 * ); out.println("<br><br>");
				 * out.println("<font>Try again : <a href=FrontPage.html>Logout</a></font>");
				 * out.println("</body>");
				 */

			}

		} catch (Exception e) {

		}

	}

}
