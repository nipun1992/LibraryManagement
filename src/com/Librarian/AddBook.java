package com.Librarian;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.JdbcConnection.Jdbc;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

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

		String sql1 = "SELECT * FROM LIBRARY_BOOK WHERE BOOKNAME = '" + request.getParameter("bookname") + "'";

		String sql2 = "SELECT * FROM LIBRARY_BOOK WHERE BOOKID = '" + request.getParameter("bookid") + "'";

		try {

			Jdbc.connect();

			if ((Jdbc.con).isClosed()) {
				System.out.println("connection closed");
			} else
				System.out.println("connection open");

			ps = (Jdbc.con).prepareStatement(sql1);

			ResultSet rs1 = ps.executeQuery();

			ps = (Jdbc.con).prepareStatement(sql2);

			ResultSet rs2 = ps.executeQuery();

			if (rs1.next()) {

				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head></head>");
				out.println("<body>");
				out.println("<h1>A book with this name already exists in Library. Please add another book</h1>");
				out.println("</body>");
				out.println("</html>");

				rd = request.getRequestDispatcher("AddBook.jsp");
				rd.include(request, response);

			} else if (rs2.next()) {
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head></head>");
				out.println("<body>");
				out.println("<h1>A book with this id already exists in Library. Please choose another bookid</h1>");
				out.println("</body>");
				out.println("</html>");

				rd = request.getRequestDispatcher("AddBook.jsp");
				rd.include(request, response);
			} else {
				String sql = "INSERT INTO LIBRARY_BOOK VALUES(?, ?, ?, ?, ?)";

				try {

					ps = (Jdbc.con).prepareStatement(sql);

					ps.setString(1, request.getParameter("bookid"));
					ps.setString(2, request.getParameter("bookname"));
					ps.setString(3, request.getParameter("streams"));
					ps.setString(4, request.getParameter("bookauthor"));

					FileInputStream fis = null;

					/*
					 * File f; int factSize = 1024 * 1024 * 1024; int fileSize = 1024 * 1024 * 1024;
					 * 
					 * String reqType = request.getContentType();
					 * 
					 * 
					 * 
					 * if (reqType.contains("multipart/form-data")) { DiskFileItemFactory df = new
					 * DiskFileItemFactory(); df.setSizeThreshold(factSize); df.setRepository(new
					 * File("C:\\Users\\NipunGupta\\Downloads")); ServletFileUpload upload = new
					 * ServletFileUpload(df); upload.setSizeMax(fileSize); List l =
					 * upload.parseRequest(request); ListIterator lit = (ListIterator)
					 * l.listIterator();
					 * 
					 * FileItem fi = (FileItem) lit.next(); String name = fi.getName(); f = new
					 * File("C:\\Users\\NipunGupta\\Downloads", name); fi.write(f);
					 * 
					 * fis = new FileInputStream(f); }
					 */

					fis = new FileInputStream(request.getParameter("bookfile"));

					ps.setBinaryStream(5, fis);

				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				sql = "INSERT INTO LIBRARY_BOOK_STATUS VALUES(?, ?, ?, ?, ?)";

				try {

					ps = (Jdbc.con).prepareStatement(sql);

					ps.setString(1, request.getParameter("bookid"));
					ps.setString(2, "Available");
					ps.setString(3, null);
					ps.setDate(4, null);
					ps.setString(5, null);

				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				rd = request.getRequestDispatcher("LibrarianLogout.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				ps.close();
				ps = null;

				Jdbc.closeConnection();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}