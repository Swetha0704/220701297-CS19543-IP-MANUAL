import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Course
 */
@WebServlet("/Course")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
			String name = request.getParameter("n1");
			String rollno = request.getParameter("n2");
			String gender = request.getParameter("n3");
			String year = request.getParameter("n4");
			String department = request.getParameter("n5");
			String section = request.getParameter("n6");
			String mobile_no = request.getParameter("n7");
			String email = request.getParameter("n8");
			String address = request.getParameter("n9");
			String city = request.getParameter("n10");
			String country = request.getParameter("n11");
			String pincode = request.getParameter("n12");

			out.println("<h2>Registered Details</h2>");
			out.println("<b>Student Name:</b> " + name+"<br>");
			out.println("<b>Roll Number:</b> " + rollno+"<br>" );
			out.println("<b>Gender:</b> " + gender+"<br>");
			out.println("<b>Year:</b> " + year+"<br>" );
			out.println("<b>Department:</b> " + department+"<br>");
	        out.println("<b>Section:</b> " + section+"<br>");
			out.println("<b>Mobile Number:</b> " + mobile_no +"<br>");
			out.println("<b>E-Mail ID:</b> " + email+"<br>");
			out.println("<b>Address:</b> " + address +"<br>");
			out.println("<b>City:</b> " + city +"<br>");
			out.println("<b>Country:</b> " + country +"<br>");
			out.println("<b>Pincode:</b> " + pincode+"<br>" );
	}
}
