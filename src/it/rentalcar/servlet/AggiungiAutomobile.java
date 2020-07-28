package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.model.Automobile;
import it.rentalcar.service.AutomobileService;


@WebServlet("/aggiungiautomobile")
public class AggiungiAutomobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AggiungiAutomobile() {
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/form-auto.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Automobile auto = null;
		try {
			AutomobileService autoS = new AutomobileService();
			auto = autoS.persist(request.getParameter("modello"), request.getParameter("targa"), request.getParameter("casaCostruttrice"), request.getParameter("annoImm"), request.getParameter("categoria"));
		}
		catch (NullPointerException e) {
			request.setAttribute("error", "auto mancante");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("automobile", auto);
	}
	
	
	
}
