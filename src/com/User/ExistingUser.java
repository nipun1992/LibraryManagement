package com.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		String usrid = request.getParameter("id1");
		String name = request.getParameter("name1");
		String password = request.getParameter("paswrd1");

		String sql = "SELECT * FROM LIBRARY_USER WHERE USER_ID = '" + usrid + "' AND NAME = '" + name
				+ "' AND PASSWORD = '" + password + "'";

		try {

			Jdbc.connect();

			RequestDispatcher rd;

			PreparedStatement st = (Jdbc.con).prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				System.out.println("User exists");

				rd = request.getRequestDispatcher("BookIssue.jsp");
				rd.forward(request, response);
			} else {

				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head></head>");
				out.println("<body>");
				out.println("<center><h1>Queried user does not exist in the Library system</h1></center><br><br>");
				out.println("</body>");
				out.println("</html>");

				request.setAttribute("exist", "true");

				rd = request.getRequestDispatcher("ExistingUser.jsp");
				rd.include(request, response);

			}

		} catch (Exception e) {

		} finally {

			try {

				Jdbc.closeConnection();

				/*
				 * (Jdbc.con).close();
				 * 
				 * if ((Jdbc.con).isClosed()) { System.out.println("connection closed"); } else
				 * System.out.println("connection open"); Jdbc.closeConnection();
				 */

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
