package ASSIGNMENT;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCInsertionConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement pstmt= null; ;

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
		System.out.println("Config object created and got the values from config object...\n\n");

		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
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

		String username = request.getParameter("username");
		String userage = request.getParameter("userage");
		String useraddress = request.getParameter("useraddr");

		String sqlInsertQuery = "insert into student (SNAME,SAGE,SADDRESS) values(?,?,?)";
		try {
			
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(userage));
				pstmt.setString(3, useraddress);
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				PrintWriter out = null;
				out = response.getWriter();
				if (rowAffected == 1) {
					out.println("<h1 style='color:green;text-align:center;'>REGISTRATION SUCCESFULL</h1>");
				} else {
					out.println(
							"<h1 style='color:red; text-align;center;'>REGISTRATION FAILED TRY AGAIN WITH THE FOLLOWING LINK</h1>");
					out.println("<a href='./reg.html'/>|REGISTRATION|</a>");
				}
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
