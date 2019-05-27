package com.JdbcConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc {

	private static Connection con;
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

	public static Connection connect() {
		if (con == null) {

			property();

			try {
				// Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName(p.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				// con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				// "system", "system");
				con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
						p.getProperty("password"));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return con;
	}

}