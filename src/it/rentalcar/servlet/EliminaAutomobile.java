package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.service.AutomobileService;
import it.rentalcar.service.UtenteService;

@WebServlet("/eliminaauto")
public class EliminaAutomobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminaAutomobile() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("el"));
		AutomobileService auto = new AutomobileService();
		auto.delete(id);
		System.out.println("Automobile eliminata");
		response.sendRedirect("listaautomobili");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
