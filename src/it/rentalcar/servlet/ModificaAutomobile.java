package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.model.Automobile;
import it.rentalcar.service.AutomobileService;

@WebServlet(name="modificaauto", urlPatterns={"/modificaauto"})
public class ModificaAutomobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaAutomobile() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/modifica-automobile.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("mod"));
		AutomobileService autoS = new AutomobileService();
		Automobile auto = autoS.update(id, request.getParameter("modello"), request.getParameter("targa"), request.getParameter("casaCostruttrice"), request.getParameter("annoImm"), request.getParameter("categoria"));
		
		response.sendRedirect("listaautomobili");
	}

}
