package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TableDisplay")
public class TableDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TableDisplay() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // creating table
	    response.setContentType("text/html");
	    PrintWriter write = response.getWriter();
	    write.println("<body style='background-color:#111827'>  </body>");
	    write.println("<h1 style='text-align:center;color:white;margin:25px'> All your information </h1>");
	    write.println("<table cellspacing=10 border=2 style='margin: 0 auto; background-color:wheat;color:black;font-weight:400'> ");


	    write.println("<tr> ");

	    write.println("<th style='padding: 10px; background-color: yellow;'>");
	    write.println("<span style='color: #333;'>Name</span>");
	    write.println("</th>");

	    write.println("<th style='padding: 10px; background-color: yellow;'>");
	    write.println("<span style='color: #333;'>Age</span>");
	    write.println("</th>");

	    write.println("<th style='padding: 10px; background-color: yellow;'>");
	    write.println("<span style='color: #333;'>City</span>");
	    write.println("</th>");

	    write.println("<th style='padding: 10px; background-color: yellow;'>");
	    write.println("<span style='color: #333;'>Email</span>");
	    write.println("</th>");

	    write.println("<th style='padding: 10px; background-color: yellow;'>");
	    write.println("<span style='color: #333;'>Phone</span>");
	    write.println("</th>");

	    write.println("<th style='padding: 10px; background-color: yellow;'>");
	    write.println("<span style='color: #333;'>Registration Date</span>");
	    write.println("</th>");

	    write.println("</tr>");

	    // fetch data from table query

	    try {
	        // load Driver class
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // connection DB
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_db_2", "root", "cp@mysql");
	        System.out.println("--connect to db---");

	        // create Statement
	        Statement st = con.createStatement();

	        // query to fetch data from
	        ResultSet alldata = st.executeQuery("SELECT * FROM SMS ");

	        // printing table data
	        if (!alldata.next()) {
	            write.println("<tr>");
	            write.println("<td colspan='6' style='text-align:center;font-size; font-size: 35px;color:red'>No data available</td>");
	            write.println("</tr>");
	        } else {
	            do {
	                write.println("<tr>");
	                write.println("<td style='padding: 10px;'>" + alldata.getString(1) + "</td>");
	                write.println("<td style='padding: 10px;'>" + alldata.getString(2) + "</td>");
	                write.println("<td style='padding: 10px;'>" + alldata.getString(3) + "</td>");
	                write.println("<td style='padding: 10px;'>" + alldata.getString(4) + "</td>");
	                write.println("<td style='padding: 10px;'>" + alldata.getString(5) + "</td>");
	                write.println("<td style='padding: 10px;'>" + alldata.getString(6) + "</td>");
	                write.println("</tr>");
	            } while (alldata.next());
	        }
	        write.println("</table>");
	        
	        System.out.println("data displayed");

	        write.println("<h1 style='text-align:center;'>");
	        write.println("<a href ='./index.html' style='text-decoration: none;color: #77dd77;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Go To Main Menu</a>");
	        write.println("</h1>");
	        
	        /*
	        
	        while (alldata.next()) {
	            write.println("<tr>");

	            write.println("<td style='padding: 10px;'>" + alldata.getString(1) + "</td>");
	            write.println("<td style='padding: 10px;'>" + alldata.getString(2) + "</td>");
	            write.println("<td style='padding: 10px;'>" + alldata.getString(3) + "</td>");
	            write.println("<td style='padding: 10px;'>" + alldata.getString(4) + "</td>");
	            write.println("<td style='padding: 10px;'>" + alldata.getString(5) + "</td>");
	            write.println("<td style='padding: 10px;'>" + alldata.getString(6) + "</td>");

	            write.println("</tr>");
	        }
	        write.println("</table>");
	        
	            */

	       

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
