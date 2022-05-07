package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String scallno = request.getParameter("callno");
		int callno = Integer.parseInt(scallno);

		com.dao.BookDAO.deletebook(callno);

		response.sendRedirect("ViewBook");

	}

}
