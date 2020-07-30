package it.rentalcar.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Utente;
import it.rentalcar.service.UtenteService;
import it.rentalcar.util.HibernateUtil;

@WebServlet("/registrautente")
public class RegistraUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistraUtente() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/form-utente.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utente user = null;
		try {
			UtenteService userS = new UtenteService();
			user = userS.persist(request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("datadinascita"), request.getParameter("email"), request.getParameter("password"));
		}
		catch (HibernateException e) {
			request.setAttribute("error", "HibernateException");
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			request.setAttribute("error", "User mancante");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("utente", user);
	}
}