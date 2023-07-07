package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.NameList;

@WebServlet("/delete")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DeleteRecord() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		System.out.println(name);

		try {
			// Load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 1.connect to db
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db_2", "root", "cp@mysql");
			System.out.println("--connected to db--");

			// 2.statement create
			Statement st = con.createStatement();
			
			//display names 
			ResultSet alldata = st.executeQuery("SELECT * FROM SMS");
			
			// message
			response.setContentType("text/html");
			PrintWriter write = response.getWriter();
			
			
			List<String> dataArray = new ArrayList<>();
			
			while(alldata.next()) {
				 String column1Data = alldata.getString("name");	
				 System.out.println(column1Data);
				 
				 dataArray.add(column1Data);
				}
			
			
			boolean recordFound = false;
			 for (int i = 0; i < dataArray.size(); ++i) {
	                if (name.equals(dataArray.get(i))) {
	                    st.executeUpdate("DELETE FROM SMS WHERE name='" + name + "'");
	                    write.println("<h1 style='color: #FF0000; font-size: 24px; font-family: Arial, sans-serif;'>Hello, '"
	                            +name+"'  Record Has Been Deleted Successfully !! <span>&#128517;</span> !!</h1>\r\n" + "");
	                    recordFound = true; // Set the flag to true when the record is found
	                    break; // Exit the loop since the record is found and deleted
	                }
	            }
			 	
			 
			 	//if record not found(false)
	            if (!recordFound) {
	                write.println("<h1 style='color: #FF0000; font-size: 24px; font-family: Arial, sans-serif;'>Hello User, '"
	                        +name+"'Record Not Found  Data Can't Be Deleted !! <span>&#128532</span> !!</h1>\r\n" + "");
	            }

			//menu

			write.println(
					"<a href ='./index.html' style='text-decoration: none;color: blue;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Go To Main Menu</a>");
			write.println(
					"<a href ='./deleteRecord.html' style='text-decoration: none;color: green;font-weight: 600;font-size: 25px;font-family: 'Courier New', Courier, monospace;'>Delete Record Again</a>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
