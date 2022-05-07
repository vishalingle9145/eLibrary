package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.E_book;
import com.bean.E_issuebook;
import com.dao.BookDAO;

@WebServlet("/ViewIssuedBooks")
public class ViewIssuedBooks extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.print("<!DOCTYPE html>");
		pw.print("<html>");

		pw.print("<style>");

		pw.print("body {\r\n" + "  margin: 0;\r\n" + "  font-family: sans-serif;\r\n"
				+ "  background-image: url(images/bg10.jpg);\r\n" + "  background-size: cover;\r\n" + "}");

		pw.print("h1{\r\n" + "	color: white;\r\n" + "	text-transform: capitalize;\r\n" + "	font-weight: 500;\r\n"
				+ "}");

		pw.print("table{\r\n" + "	color: white;\r\n" + "	width:60%;\r\n" + "	text-align: center;\r\n"
				+ "	border-color: white;\r\n" + "	font-family: arial,sans-serif;\r\n" + "	padding: 1px; \r\n " + "}");

		pw.print("td,th{\r\n" + "	border: 1px solid #dddddd;\r\n" + "	padding: 7px;\r\n" + "}");

		pw.print(".topnav {\r\n" + "	  overflow: hidden;\r\n" + "	  background-color: #333;\r\n"
				+ "	  margin-top: 5px;\r\n" + "	}");

		pw.print(".topnav a {\r\n" + "	  float: left;\r\n" + "	  color: #f2f2f2;\r\n" + "	  text-align: center;\r\n"
				+ "	  padding: 14px 16px;\r\n" + "	  text-decoration: none;\r\n" + "	  font-size: 17px;\r\n" + "	}");

		pw.print(".topnav a:hover {\r\n" + "	  background-color: #ddd;\r\n" + "	  color: black;\r\n" + "	}");

		pw.print(".topnav a.active {\r\n" + "	  background-color: #4CAF50;\r\n" + "	  color: white;\r\n" + "	}");

		pw.print("td{\r\n" + "	background-color: #dddddd;\r\n" + "	color: black;\r\n" + "}");

		pw.print("</style>");

		pw.println("<head>");
		pw.println("<title>View Issued Books</title>");
		pw.println("</head>");

		pw.println("<body>");

		pw.println("<div class=\"topnav\">\r\n" + "		<a class=\"active\" href=\"navlibrarian.html\">Home</a>\r\n"
				+ "		<a href=\"addbookform.html\">Add Book</a>\r\n" + "		<a href=\"ViewBook\">View Book</a>\r\n"
				+ "		<a href=\"issuebookform.html\">Issue Book</a>\r\n"
				+ "		<a href=\"\">View Issued Book</a>\r\n" + "		<a href=\"returnBook.html\">Return Book</a>\r\n"
				+ "		<a href=\"LogoutLibrarian\">LogOut</a>\r\n" + "	</div>");

		pw.println("<h1>Issued Books</h1>");

		List<E_issuebook> list = BookDAO.viewIssuedBooks();

		pw.println("<table border='1'>");
		pw.println(
				"<tr><th>CallNo</th><th>Student Id</th><th>Student Name</th><th>Student MobileNo</th><th>Issued Date</th><th>Return Status</th></tr>");

		for (E_issuebook bean : list) {
			pw.println("<tr><td>" + bean.getCallNo() + "</td><td>" + bean.getId() + "</td><td>" + bean.getName()
					+ "</td><td>" + bean.getMobileNo() + "</td><td>" + bean.getDate() + "</td><td>"
					+ bean.getReturnstatus() + "</td></tr");
		}

		pw.println("</body>");

		pw.print("</html>");

	}

}
