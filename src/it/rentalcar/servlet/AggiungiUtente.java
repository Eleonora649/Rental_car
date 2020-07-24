package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.model.Utente;
import it.rentalcar.service.UtenteService;

@WebServlet("/aggiungiutente")
public class AggiungiUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 public AggiungiUtente() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtenteService user = new UtenteService();
//		user.persist((Utente) request.getAttribute("utente"));
	}

}
