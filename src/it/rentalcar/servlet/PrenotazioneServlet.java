package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rentalcar.model.Automobile;
import it.rentalcar.model.Prenotazione;
import it.rentalcar.model.Utente;
import it.rentalcar.service.AutomobileService;
import it.rentalcar.service.PrenotazioneService;


@WebServlet("/prenotaauto")
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PrenotazioneServlet() {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("currentUser");

		if(request.getParameter("pren")!=null) {
			if(utente!=null) { 	//messaggio di doversi loggare o registrare

				int idAutomobile = Integer.parseInt(request.getParameter("pren"));
				AutomobileService autoS = new AutomobileService();
				Automobile auto = autoS.findAutomobileId(idAutomobile);
				System.out.println(auto.getModello());
				session.setAttribute("automobile", auto);


			}else {
				response.sendRedirect("login");
			}
		}
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/prenotazione.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("currentUser");
		
		if(request.getParameter("pren")!=null) {
			int idAutomobile = Integer.parseInt(request.getParameter("pren"));
			AutomobileService autoS = new AutomobileService();
			Automobile auto = autoS.findAutomobileId(idAutomobile);
			System.out.println(auto.getModello());
			session.setAttribute("automobile", auto);
			if(utente!=null) { 
				if(request.getParameter("inizioNoleggio") != null && request.getParameter("fineNoleggio") != null) {
					PrenotazioneService prenS = new PrenotazioneService();
					Prenotazione pren = prenS.persist(request.getParameter("inizioNoleggio"), request.getParameter("fineNoleggio"), utente, auto);
					
					session.setAttribute("prenotazione", pren);
				}
			}
		}
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/riepilogo-prenotazione.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}
}