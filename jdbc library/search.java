	

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
        	String URL = "jdbc:mysql://localhost:3306/library";
        	Connection con=DriverManager.getConnection(URL,"root","");
        	String query="select * from books where bname=?";
        	PreparedStatement ps=con.prepareStatement(query);
        	String bname = request.getParameter("bname");
            if (bname == null || bname.isEmpty()) {
                out.println("Error: Book name must be provided.");
                return;
            }
        	ps.setString(1,bname);
        	ResultSet rs=ps.executeQuery();
        	out.println("<table border='1'>");
        	out.println("<tr>");
        	out.println("<td>Book ID</td>");
        	out.println("<td>Book Name</td>");
        	out.println("<td>Author Name</td>");
        	out.println("<td>Publisher Name</td>");
        	out.println("<td>Edition</td>");
        	out.println("<td>Price</td>");
        	out.println("</tr>");
        	while (rs.next()) {
        	out.println("<tr>");
        	out.println("<td>" + rs.getInt("bid") +"</td>");
        	out.println("<td>" + rs.getString("bname")+"</td>");
        	out.println("<td>" + rs.getString("author") + "</td>");
        	out.println("<td>" + rs.getString("pub") + "</td>");
        	out.println("<td>" + rs.getInt("edi") + "</td>");
        	out.println("<td>" + rs.getDouble("price") +"</td>");
        	out.println("</tr>");
        	}
        	out.println("</table>");
    	}
    	catch(Exception e)
    	{
    		out.println(e);
    	}

	}

}
