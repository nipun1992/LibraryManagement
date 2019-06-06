package com.JdbcConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc {

	public static Connection con;
	private static FileInputStream fis;
	private static Properties p;

	private Jdbc() {

	}

	private static void property() {

		p = new Properties();

		try {
			fis = new FileInputStream("C:\\Users\\NipunGupta\\eclipse-workspace2\\LibraryManagement\\Jdbc.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void connect() {

		// System.out.println("Before con");

		if (con == null) {

			// System.out.println("Inside con");

			property();

			// System.out.println("After property()");

			try {
				Class.forName(p.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
						p.getProperty("password"));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Could not check con");
		}

		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p = null;

		// return con;
	}

	public static void closeConnection() throws SQLException {

		con.close();
		con = null;

	}

}