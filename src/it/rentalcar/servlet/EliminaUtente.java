package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rentalcar.service.UtenteService;


@WebServlet("/eliminautente")
public class EliminaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   public EliminaUtente() { 
    }

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		   		
   	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("idUtente"));
		UtenteService utente = new UtenteService();
		utente.delete(id);
		System.out.println("Utente eliminato");
		response.sendRedirect("listautenti");
		
	}

}
