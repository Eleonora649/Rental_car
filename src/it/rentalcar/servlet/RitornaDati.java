package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.service.UtenteService;


@WebServlet("/ritornadati")
public class RitornaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RitornaDati() {
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/modifica-utente.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//visualizzare i dati del db all'interno del form 
		UtenteService utente = new UtenteService(); 
		utente.ritornaDati(Integer.parseInt(request.getParameter("mod"))); 
		//invia dati a sevlet di modifica dati
		response.sendRedirect("modificautente");
		 
	}

}
