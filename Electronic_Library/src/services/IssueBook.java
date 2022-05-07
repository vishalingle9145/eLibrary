package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;

@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String scallno = request.getParameter("callno");
		int callno = Integer.parseInt(scallno);

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");

		com.bean.E_issuebook bean = new com.bean.E_issuebook(callno, id, name, mobile);

		int i = BookDAO.issueBook(bean);

		if (i > 0) {
			request.getRequestDispatcher("issuebookform.html").include(request, response);
			pw.print("<h3>Book issued successfully</h3>");
		} else {
			request.getRequestDispatcher("issuebookform.html").include(request, response);
			pw.print("<h3>Book not issued</h3>");
		}
	}

}
