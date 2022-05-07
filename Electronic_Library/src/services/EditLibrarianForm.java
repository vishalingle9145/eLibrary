package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.E_librarian;
import com.dao.BookDAO;
import com.dao.LibrarianDAO;

@WebServlet("/EditLibrarianForm")
public class EditLibrarianForm extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.println("<!DOCTYPE html>");
		pw.print("<html>");

		pw.println("<head>");
		pw.println("<title>Edit Librarian Form</title>");
		pw.print("<link rel='stylesheet' type='text/css' href='editlibrarianform.css'>");
		pw.println("</head>");

		pw.println("<body>");

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		E_librarian bean = LibrarianDAO.viewById(id);

		pw.print("<h1>Edit Librarian</h1>");
		pw.print("<form class='box' action='EditLibrarian' method='post'>");
		pw.print("<input type='hidden' name='id' value='" + bean.getId() + "'/>");

		pw.print("<label>Name:</label><br>");
		pw.print("<input  type='text' value='" + bean.getName() + "' name='name' placeholder='Name' required/><br>");

		pw.print("<label>Email:</label><br>");
		pw.print(
				"<input  type='email' value='" + bean.getEmail() + "' name='email' placeholder='Email' required/><br>");

		pw.print("<label>Password:</label><br>");
		pw.print("<input  type='password' value='" + bean.getPassword()
				+ "' name='password' placeholder='Password' required/><br>");

		pw.print("<label>Mobile No:</label><br>");
		// pw.print("<input type='number' value='"+bean.getMobileNo()+"' name='mobile'
		// placeholder='MobileNo'/>");

		pw.print("<input type='text' value='" + bean.getMobileNo()
				+ "' name='mobile' placeholder='MobileNo' title='Enter Valid MobileNo' pattern='[1-9]{1}[0-9]{9}' required/>");

		pw.print("<input type='submit' value='Update'>");

		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");

	}

}
