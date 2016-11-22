package com.vtracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "admin";
		String password = "admin123";
		String jdbcUrl = "jdbc:mysql://localhost:3306/volunteer_database?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try{
			PrintWriter out = response.getWriter();
			
			Class.forName(driver);
			
			out.println("Connecting to database " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("success!!!");
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
