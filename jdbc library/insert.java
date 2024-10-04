import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
	    try {       
	    	Class.forName("com.mysql.cj.jdbc.Driver");
            String option = request.getParameter("m7");
        	switch(option)
        	{
        	case "Insert":
        		insertbook(request,response);
        		break;
        	case "Delete":
        		deletebook(request,response);
        		break;
        	case "Update":
        		updatebook(request,response);
        		break;
        	default:
        		out.println("Details not Entered"); 
        	}
	    }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	}
        	
        	public void insertbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException,ClassNotFoundException {
        		Class.forName("com.mysql.cj.jdbc.Driver");
            	String URL = "jdbc:mysql://localhost:3306/library";
            	Connection con = DriverManager.getConnection(URL,"root","");
            	PrintWriter out = response.getWriter();

        		String query="insert into books values(?,?,?,?,?,?)";
        		PreparedStatement st = con.prepareStatement(query);
        		st.setInt(1, Integer.parseInt(request.getParameter("m2")));
        		st.setString(2, request.getParameter("m3"));
        		st.setString(3, request.getParameter("m4"));
        		st.setString(4, request.getParameter("m8"));
        		st.setInt(5, Integer.parseInt(request.getParameter("m9")));
        		st.setDouble(6, Double.parseDouble(request.getParameter("m5")));
        		int res= st.executeUpdate();
        		if(res>=1)
        		{
        			out.println("Success");
        		}
        		else
        		{
        			out.println("Failure");
        		}
        		st.close();
        		con.close();
            }  
        	public void deletebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException,ClassNotFoundException {
        		Class.forName("com.mysql.cj.jdbc.Driver");
            	String URL = "jdbc:mysql://localhost:3306/library";
            	Connection con = DriverManager.getConnection(URL,"root","");
            	PrintWriter out = response.getWriter();
            	String query="delete from books where bid=?";
            	PreparedStatement st = con.prepareStatement(query);
            	st.setInt(1, Integer.parseInt(request.getParameter("m2")));
            	int k=st.executeUpdate();
            	if(k>0)
            	{
            		out.println("Book is deleted successfully");
            	}
            	else
            	{
            		out.println("Book is not deleted");
            	}
            	st.close();
            	con.close();
        	}
        	public void updatebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException,ClassNotFoundException {
        		Class.forName("com.mysql.cj.jdbc.Driver");
            	String URL = "jdbc:mysql://localhost:3306/library";
            	Connection con = DriverManager.getConnection(URL,"root","");
            	PrintWriter out = response.getWriter();
            	String query="update book set price=? where bid=?";
            	PreparedStatement st=con.prepareStatement(query);
            	st.setDouble(1, Double.parseDouble(request.getParameter("m5")));
            	st.setInt(2, Integer.parseInt(request.getParameter("m2")));
            	int d=st.executeUpdate();
            	if(d>0)
            	{
            		out.println("Book is updated successfully");
            	}
            	else
            	{
            		out.println("Book is not updated");
            	}
            	st.close();
            	con.close();
        	}


}
