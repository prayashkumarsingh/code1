package Assignment;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded succesufully....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet Object is initialised with config object data....");
		ServletContext context = getServletContext();

		String url = context.getInitParameter("url");
		String username = context.getInitParameter("user");
		String password = context.getInitParameter("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

		try {
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection established succesfully....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red; text-align:center;'>....STUDENT INFORMATION....</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>ID</th><th>NAME</th><th>AGE</th><th>ADDRESS</th></tr>");

		java.sql.Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select SID,SNAME,SAGE,SADDRESS from student");
			while (resultSet.next()) {
				out.println("<tr>");
				out.println("<td>" + resultSet.getInt(1) + "</td>");
				out.println("<td>" + resultSet.getString(2) + "</td>");
				out.println("<td>" + resultSet.getInt(3) + "</td>");
				out.println("<td>" + resultSet.getString(4) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
