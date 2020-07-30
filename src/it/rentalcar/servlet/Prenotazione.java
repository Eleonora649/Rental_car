package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rentalcar.model.Automobile;
import it.rentalcar.service.AutomobileService;


@WebServlet("/prenotaauto")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Prenotazione() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("currentUser")!=null) { 	//messaggio di doversi loggare o registrare
			if(request.getParameter("pren")!=null) {
				int idAutomobile = Integer.parseInt(request.getParameter("pren"));
				AutomobileService autoS = new AutomobileService();
				Automobile auto = autoS.findAutomobileId(idAutomobile);
				System.out.println(auto.getModello());
				session.setAttribute("automobile", auto);
				
			//dati del cliente?
			}
		}
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/prenotazione.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
