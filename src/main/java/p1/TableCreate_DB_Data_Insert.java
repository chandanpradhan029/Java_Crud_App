package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableCreate_DB_Data_Insert")
public class TableCreate_DB_Data_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TableCreate_DB_Data_Insert() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter write =response.getWriter();
		
		write.println("<table");
		
		write.println("<tr>");
		
		write.println("<th>Name</th>");
		write.println("<th>City</th>");
		write.println("<th>Email</th>");
		write.println("<th>Email</th>");
		
		
		
		write.println("</tr>");
		
		write.println("</table");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
