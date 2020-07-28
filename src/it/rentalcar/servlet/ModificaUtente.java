package it.rentalcar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.model.Utente;
import it.rentalcar.service.UtenteService;

@WebServlet(name="modificautente", urlPatterns={"/modificautente"})
public class ModificaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaUtente() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/modifica-utente.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("mod"));
		UtenteService utenteS = new UtenteService();
		Utente u = utenteS.update(id, request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("data"), request.getParameter("email"), request.getParameter("password"));
		
		response.sendRedirect("listautenti");
	}
}
