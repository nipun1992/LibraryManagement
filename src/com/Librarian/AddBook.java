package com.Librarian;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

		RequestDispatcher rd;

		String sql = "SELECT * FROM LIBRARY_BOOK WHERE BOOKNAME = '" + request.getParameter("bookname") + "'";

		con = Jdbc.connect();

		boolean fileAlreadyExists = false;

		try {

			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String bookAlreadyExists = "The book already exists in Library. Please add another book";
				request.setAttribute("exists", bookAlreadyExists);

				fileAlreadyExists = true;

				rd = request.getRequestDispatcher("AddBook.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (fileAlreadyExists == false) {
			sql = "INSERT INTO LIBRARY_BOOK VALUES(?, ?, ?, ?, ?)";

			try {

				ps = con.prepareStatement(sql);

				ps.setString(1, request.getParameter("bookid"));
				ps.setString(2, request.getParameter("bookname"));
				ps.setString(3, request.getParameter("streams"));
				ps.setString(4, request.getParameter("bookauthor"));

				FileInputStream fis = new FileInputStream(request.getParameter("bookfile"));
				ps.setBinaryStream(5, fis);

			} catch (Exception e) {
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

			rows = 0;

			sql = "INSERT INTO LIBRARY_BOOK_STATUS VALUES(?, ?, ?, ?, ?)";

			try {

				ps = con.prepareStatement(sql);

				ps.setString(1, request.getParameter("bookid"));
				ps.setString(2, "Available");
				ps.setString(3, null);
				ps.setDate(4, null);
				ps.setString(5, null);

			} catch (Exception e) {
				e.printStackTrace();
			}

			rows = 0;

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

			/*
			 * if (ps != null) { try { ps.close(); ps = null; } catch (SQLException e) {
			 * e.printStackTrace(); } }
			 * 
			 * if (con != null) { try { con.close(); con = null; } catch (SQLException e) {
			 * e.printStackTrace(); } }
			 */

			rd = request.getRequestDispatcher("LibrarianLogout.jsp");
			rd.forward(request, response);

		}
	}

}