package it.rentalcar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.model.Utente;
import it.rentalcar.service.UtenteService;

@WebServlet(name="listautenti", urlPatterns={"/listautenti"})
public class ListaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaUtenti() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UtenteService users = new UtenteService();
			List<Utente> listaUtenti = users.listAll();
			request.setAttribute("listaUtenti", listaUtenti);
			
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/lista-utenti.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
