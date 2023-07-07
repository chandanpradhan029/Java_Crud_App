package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/save")
public class SaveFormData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveFormData() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
		System.out.println(name);
		System.out.println(age);
		System.out.println(city);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(date);

		try {
			// Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 1.connect to db
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db_2", "root", "cp@mysql");
			System.out.println("--connected to db--");

			// 2.statement create
			Statement st = con.createStatement();

			// 3.query to insert form data into the table
			st.executeUpdate("INSERT INTO SMS values('" + name + "' , '" + age + "' , '" + city + "' , '" + email
					+ "' , '" + phone + "' ,'" + date + "')");
			System.out.println("--data inserted--");
			
			//message
			response.setContentType("text/html");
			PrintWriter write =response.getWriter();
			write.println("<h1 style='color: #FF0000; font-size: 24px; font-family: Arial, sans-serif;'>Hello, '"+name+"' Information Saved sucessfully !! <span>&#128517;</span> !!</h1>\r\n"
					+ "");
			write.println("<a href ='./index.html' style='text-decoration: none;color: blue;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Go To Main Menu</a>");
			write.println("<a href ='./saveData.html' style='text-decoration: none;color: green;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Save Student Details Again</a>");
//			response.sendRedirect("login1.html");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
