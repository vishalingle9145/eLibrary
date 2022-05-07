package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.E_book;
import com.dao.BookDAO;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String scallno = request.getParameter("callno");
		int callno = Integer.parseInt(scallno);
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String squantity = request.getParameter("quantity");
		int quantity = Integer.parseInt(squantity);

		E_book bean = new E_book(callno, name, author, publisher, quantity);

		int i = BookDAO.saveBook(bean);

		if (i > 0) {
			request.getRequestDispatcher("addbookform.html").include(request, response);
			pw.print("<h3>Book added successfully</h3>");
		} else {
			request.getRequestDispatcher("addbookform.html").include(request, response);
			pw.print("<h3>Book not added</h3>");
		}
		pw.close();

	}

}
