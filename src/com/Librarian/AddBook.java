package com.Librarian;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JdbcConnection.Jdbc;

/**
 * Servlet implementation class AddBook
 */
//@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement ps;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if ((request.getParameter("bookname").length() == 0)) {
			response.sendRedirect("AddBook.jsp");
		} else if (request.getParameter("bookid").length() < 4) {
			response.sendRedirect("AddBook.jsp");
		} else if (request.getParameter("streams").equals("----")) {
			response.sendRedirect("AddBook.jsp");
		} else if (request.getParameter("bookauthor").length() == 0) {
			response.sendRedirect("AddBook.jsp");
		} else {

			String sql = "INSERT INTO LIBRARY_BOOK VALUES(?, ?, ?, ?, ?)";

			con = Jdbc.connect();

			try {

				ps = con.prepareStatement(sql);

				ps.setString(1, request.getParameter("bookid"));
				ps.setString(2, request.getParameter("bookname"));
				ps.setString(3, request.getParameter("streams"));
				ps.setString(4, request.getParameter("bookauthor"));

				try {
					FileInputStream fis = new FileInputStream(request.getParameter("bookfile"));
					ps.setBinaryStream(5, fis);

				} catch (FileNotFoundException e) {
					ps.setBinaryStream(5, null);
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

			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("BookIssue.jsp");
			 * rd.forward(request, response);
			 */
		}
	}

}