package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.StringUtils;

import it.rentalcar.model.Utente;
import it.rentalcar.service.LoginService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String adminEmail="admin@gmail.com";
	private String adminPassword="admin";

	public Login() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/login.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginService login = new LoginService();

		Utente currentUser = null;
		try {
			currentUser = login.authenticate(email, password);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(!StringUtils.isNullOrEmpty(email)) {
			if(currentUser != null) {
				System.out.println("accesso");
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("start");
			}
			else {
				System.out.println("accesso negato");
				response.sendRedirect("login");
			}
		}
		else {
			session.setAttribute("error", "Accesso negato");
			response.sendRedirect("login");
		}
	}



}
