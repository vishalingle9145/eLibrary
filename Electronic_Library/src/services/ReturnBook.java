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

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String scallno = request.getParameter("callno");
		int callno = Integer.parseInt(scallno);

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		int i = BookDAO.returnBook(callno, id);

		if (i > 0) {
			request.getRequestDispatcher("returnBook.html").include(request, response);
			pw.print("<h3>Book returned Successfully</h3>");
		} else {
			request.getRequestDispatcher("returnBook.html").include(request, response);
			pw.print("<h3>Unable to return book</h3>");
		}
		pw.close();

	}

}
