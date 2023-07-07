package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//fetch data from front end 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);

		
		try {
			//Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//1.connected DB
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/my_db_2","root","cp@mysql");
			System.out.println("--connect to Db---");
			
			//2.Create statement 
			Statement st = con.createStatement();
			
			//3. verify login query ( from table )
			ResultSet credential =st.executeQuery("select * from login Where email='"+email+"' and password='"+password+"'  ");
//			System.out.println(credential.next());
			
			//message display to web
			response.setContentType("text/html");
			PrintWriter write =response.getWriter();
			if(credential.next()==true) {
				response.sendRedirect("./index.html"); 
//				write.println("<h1> '"+email+"' <span>&#128512;<span> login sucess welcome to student management system </h1>");
//				write.println("<a href ='./index.html' style='text-decoration: none;color: blue;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Go To Main Menu</a>");
//				write.println("<a style='text-decoration: none;color: red;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;' href='http://localhost:8080/04_web_app4_curd_application/TableDisplay'>Show record</a>");
//				
			}
			else {
				write.println("<h1> hey  <span>&#128512;<span> invalid credential we can't give you access to our portal  </h1>");
//				write.println("<a href ='./index.html' style='text-decoration: none;color: blue;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Go To Main Menu</a>");
			}

		}
		catch(Exception e) {
			e.printStackTrace();
	}
}
	}



