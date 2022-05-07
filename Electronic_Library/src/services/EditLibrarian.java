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

@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobileno = request.getParameter("mobile");

		E_librarian bean = new E_librarian(id, name, email, password, mobileno);
		LibrarianDAO.updateLibrarian(bean);

		response.sendRedirect("ViewLibrarian");
	}

}
