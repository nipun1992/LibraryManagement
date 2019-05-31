package com.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JdbcConnection.Jdbc;

/**
 * Servlet implementation class BookIssue
 */
//@WebServlet("/BkIssue")
public class BookIssue extends HttpServlet {

	PreparedStatement st;

	private Connection con;

	private static final long serialVersionUID = 1L;

	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookname = request.getParameter("bookname");

		String sql = "SELECT * FROM LIBRARY_BOOK WHERE BOOKNAME = '" + bookname + "'";

		con = Jdbc.connect();

		RequestDispatcher rd;

		try {

			st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				System.out.println("BOOK EXISTS");

				InputStream is = rs.getBinaryStream(5);

				int filelength = is.available();

				String filename = rs.getString(2);
				String filepath = "C:\\Users\\NipunGupta\\Downloads";

				ServletContext context = getServletContext();
				String mimeType = context.getMimeType(filename);

				if (mimeType == null) {
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				String headerValue = String.format("attachment; filename=\"%s\"", filename);
				response.setHeader("Content-Disposition", headerValue);

				OutputStream os = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytesRead);
				}

				is.close();
				os.close();

				request.setAttribute("NoBook", null);

				rd = request.getRequestDispatcher("IssueSuccessful.jsp");
				// rd.forward(request, response);

			} else {
				System.out.println("No such book");

				String noBookMessage = "No such book exists in the Library";

				request.setAttribute("NoBook", noBookMessage);

				rd = request.getRequestDispatcher("BookIssue.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
