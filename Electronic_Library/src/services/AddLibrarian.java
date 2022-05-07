package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.E_librarian;
import com.dao.LibrarianDAO;

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobileNo = request.getParameter("mobile");

		E_librarian bean = new E_librarian(name, email, password, mobileNo);
		LibrarianDAO.saveLibrarian(bean);

		request.getRequestDispatcher("addLibrarian.html").include(request, response);
		pw.print("<br><h3>Librarian added successfully</h3>");

		pw.close();
	}

}
