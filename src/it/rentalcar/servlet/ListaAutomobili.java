package it.rentalcar.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rentalcar.model.Automobile;
import it.rentalcar.service.AutomobileService;


@WebServlet(name="listaautomobili", urlPatterns={"/listaautomobili"})
public class ListaAutomobili extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaAutomobili() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AutomobileService auto = new AutomobileService();
		List<Automobile> listaAutomobili = auto.listAll();
		request.setAttribute("listaAutomobili", listaAutomobili);
		
	request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/lista-automobili.jsp").include(request, response);
	request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
