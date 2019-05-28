package com.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
		System.out.println("**************Loading*****************");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUser() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("**************Construction*****************");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		System.out.println("**************Initialisation*****************");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		if ((request.getParameter("fullname").length() == 0)) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("userid").length() < 4) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("password").length() < 4) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("sem") == null) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("branch").equals("----")) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("age").equals("")) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("r1") == null) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("num") == null) {
			response.sendRedirect("CreateUser.jsp");
		} else if (request.getParameter("eml") == null) {
			response.sendRedirect("CreateUser.jsp");
		} else {

			String sql = "INSERT INTO LIBRARY_USER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, null, 'Y')";

			con = Jdbc.connect();

			try {

				ps = con.prepareStatement(sql);

				ps.setString(1, request.getParameter("userid"));
				ps.setString(2, request.getParameter("password"));
				ps.setString(3, request.getParameter("fullname"));
				ps.setInt(4, Integer.parseInt(request.getParameter("sem")));
				ps.setString(5, request.getParameter("branch"));
				ps.setString(6, request.getParameter("r1"));
				ps.setInt(7, Integer.parseInt(request.getParameter("age")));
				ps.setString(8, request.getParameter("num"));
				ps.setString(9, request.getParameter("eml"));
				ps.setString(11, request.getParameter("state"));

				try {
					FileInputStream fis = new FileInputStream(request.getParameter("im"));
					ps.setBinaryStream(10, fis);
				} catch (FileNotFoundException e) {
					ps.setBinaryStream(10, null);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			int rows = 0;

			try {
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (rows != 0) {
				System.out.println("Successful");
			} else {
				System.out.println("Unsuccessful");
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("BookIssue.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("**************Destruction*****************");
	}

}