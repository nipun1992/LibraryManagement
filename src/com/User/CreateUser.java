package com.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JdbcConnection.Jdbc;

/**
 * Servlet implementation class CreateUser
 */
//@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement ps;
	HttpSession session;

	static {
		System.out.println("**************Loading Create User*****************");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUser() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("**************Construction Create User*****************");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		System.out.println("**************Initialisation Create User*****************");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sql = "INSERT INTO LIBRARY_USER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, null, 'Y')";

		RequestDispatcher rd;

		try {

			Jdbc.connect();

			ps = (Jdbc.con).prepareStatement(sql);

			ps.setString(1, request.getParameter("userid"));
			ps.setString(2, request.getParameter("password"));
			ps.setString(3, request.getParameter("fullname"));
			ps.setInt(4, Integer.parseInt(request.getParameter("sem")));
			ps.setString(5, request.getParameter("branch"));

			// System.out.println("Hello" + request.getParameter("branch") + "Nice");

			ps.setString(6, request.getParameter("r1"));
			ps.setInt(7, Integer.parseInt(request.getParameter("age")));
			ps.setString(8, request.getParameter("num"));
			ps.setString(9, request.getParameter("eml"));

			try {
				FileInputStream fis = new FileInputStream(request.getParameter("im"));
				ps.setBinaryStream(10, fis);

			} catch (FileNotFoundException e) {
				ps.setBinaryStream(10, null);
			}

			ps.setString(11, request.getParameter("state"));

		} catch (SQLException e) {
			e.printStackTrace();

			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.println("Exception : " + e.getMessage() + "<br><br>");
			out.println("</body>");

			rd = request.getRequestDispatcher("CreateUser.jsp");
			rd.include(request, response);
		}

		int rows = 0;

		try {
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.println("Exception : " + e.getMessage() + "<br><br>");
			out.println("</body>");

			rd = request.getRequestDispatcher("CreateUser.jsp");
			rd.include(request, response);
		}

		if (rows != 0) {
			System.out.println("Successful");
			rd = request.getRequestDispatcher("AccountCreated.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Unsuccessful");

			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			out.println("<br><br>Unsuccessful<br><br>");
			out.println("</body>");

			rd = request.getRequestDispatcher("CreateUser.jsp");
			rd.include(request, response);

		}

		try {
			ps.close();
			ps = null;
			Jdbc.closeConnection();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("**************Destruction Create User*****************");
	}

}