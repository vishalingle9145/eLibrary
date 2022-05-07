package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminLoginDAO;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String email = request.getParameter("Email");
		String password = request.getParameter("Password");

		if (AdminLoginDAO.validateLibrarian(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", "true");

			request.getRequestDispatcher("naviadmin.html").include(request, response);

		} else {

			pw.print("<style>");

			pw.print("h3 {\r \n" + "color: #ff0000;" + "margin-left: 10px;" + "margin-top: 5px;" + "}");

			pw.print("</style>");

			pw.println("<h3>Email or Password error...!!</h3>");

			request.getRequestDispatcher("index.html").include(request, response);
		}

	}

}
