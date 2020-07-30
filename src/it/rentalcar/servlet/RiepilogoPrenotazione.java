package it.rentalcar.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rentalcar.model.Automobile;
import it.rentalcar.model.Utente;
import it.rentalcar.service.AutomobileService;
import it.rentalcar.service.PrenotazioneService;

@WebServlet("/riepilogoprenotazione")
public class RiepilogoPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RiepilogoPrenotazione() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nome dell'utente che noleggia
		int idAutomobile = Integer.parseInt(request.getParameter("pren"));
		AutomobileService autoS = new AutomobileService();
		Automobile auto = autoS.findAutomobileId(idAutomobile);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("currentUser")!=null) {
			Utente utente = (Utente) session.getAttribute("currentUser");
			
			if(request.getParameter("inizioNoleggio") != null && request.getParameter("fineNoleggio") != null) {
				String dataInizio = request.getParameter("inizioNoleggio");
				String dataFine = request.getParameter("fineNoleggio");

				PrenotazioneService prenotS = new PrenotazioneService();
//				Prenotazione pren = prenotS.persist(dataInizio, dataFine, utente, auto);
			}
		}
		
		
		
		//dati dell'automobile noleggiata
		
		//periodo di noleggio
		
		//conferma || pagamento
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/navbar.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/riepilogo-prenotazione.jsp").include(request, response);
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
