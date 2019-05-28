package com.Librarian;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyLibrarian
 */
//@WebServlet("/Librarian")
public class VerifyLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyLibrarian() {
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

		if (request.getParameter("librarianid").equals("College")
				&& request.getParameter("librarianpassword").equals("Library")) {
			RequestDispatcher rd = request.getRequestDispatcher("AddBook.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("LibrarianLogin.jsp");
		}
	}

}
