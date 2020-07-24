package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import it.rentalcar.model.Utente;
import it.rentalcar.service.UtenteService;

@WebServlet("/modificautente")
public class ModificaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaUtente() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("mod"));
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/modifica-utente.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtenteService utenteS = new UtenteService();
		utenteS.findUtenteId(Integer.parseInt(request.getParameter("mod")));
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String data = request.getParameter("data");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
			
		Utente utente = null;
		try {
		//	utente = utenteS.update(idUtente, utente);
		} catch (HibernateException e) {
			request.setAttribute("error", "HibernateException");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("utente", utente);
		response.sendRedirect("listautenti");
	}
}
