package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.E_librarian;
import com.dao.LibrarianDAO;

@WebServlet("/ViewLibrarian")
public class ViewLibrarian extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.print("<!DOCTYPE html>");
		pw.print("<html>");

		pw.print("<style>");

		pw.print("body {\r\n" + "  margin: 0;\r\n" + "  font-family: sans-serif;\r\n"
				+ "  background-image: url(images/bg4.jpg);\r\n" + "  background-size: cover;\r\n"
				+ "  padding-left: 5px; \r\n" + "}");

		pw.print(".topnav {\r\n" + "  overflow: hidden;\r\n" + "  background-color: #333;\r\n"
				+ "  margin-top: 5px;\r\n" + "}");

		pw.print(".topnav a {\r\n" + "  float: left;\r\n" + "  color: #f2f2f2;\r\n" + "  text-align: center;\r\n"
				+ "  padding: 14px 16px;\r\n" + "  text-decoration: none;\r\n" + "  font-size: 17px;\r\n" + "}");

		pw.print(".topnav a:hover {\r\n" + "  background-color: #ddd;\r\n" + "  color: black;\r\n" + "}");
		pw.print(".topnav a.active {\r\n" + "  background-color: #4CAF50;\r\n" + "  color: white;\r\n" + "}");

		pw.print("h1{\r\n" + "	color: white;\r\n" + "	font-weight: 500;\r\n" + "	text-transform: capitalize;\r\n"
				+ "}");

		pw.print("table{\r\n" + "	color: white;\r\n" + "	width: auto;\r\n" + "	text-align: center;\r\n"
				+ "	border-color: white;\r\n" + "	font-family: arial,sans-serif;\r\n" + "	padding: 2px;\r\n" + "}");

		pw.print("td,th{\r\n" + "	border: 1px solid #dddddd;\r\n" + "	padding: 7px;\r\n" + "}");

		pw.print("td{\r\n" + "	background-color: #dddddd;\r\n" + "	color: black;\r\n" + "}");

		pw.print("</style>");

		pw.println("<head>");
		pw.println("<title>View Librarian</title>");
		pw.println("</head>");

		pw.println("<body>");

		pw.print("<div class=\"topnav\">\r\n" + "  <a class=\"active\" href=\"naviadmin.html\">Home</a>\r\n"
				+ "  <a href=\"addLibrarian.html\">Add Librarian</a>\r\n" + "  <a href=\"\">View Librarian</a>\r\n"
				+ "  <a href=\"LogoutLibrarian\">Logout</a>\r\n" + "</div>");

		pw.println("<h1>View Librarian</h1>");

		List<E_librarian> list = LibrarianDAO.viewAllLibrarianData();

		pw.println("<table border='2'>");
		pw.println(
				"<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");

		for (E_librarian bean : list) {
			pw.println("<tr><td>" + bean.getId() + "</td><td>" + bean.getName() + "</td><td>" + bean.getEmail()
					+ "</td><td>" + bean.getPassword() + "</td><td>" + bean.getMobileNo()
					+ "</td><td><a href='EditLibrarianForm?id=" + bean.getId()
					+ "'>Edit</a></td><td><a href='DeleteLibrarian?id=" + bean.getId() + "' onclick=\"return confirm('Are you sure you want to delete this item')\">Delete</a></td></tr>");
		}
		pw.println("</table>");

		pw.close();
	}

}
