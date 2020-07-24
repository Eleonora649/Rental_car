package test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Utente;
import it.rentalcar.util.HibernateUtil;


@WebServlet("/apptest")
public class AppTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppTest() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = new Date();
		try {
			birthDate = dateFormat.parse("1994-07-21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Utente utente = new Utente("Giorgio", "Franco", birthDate ,"giorgio.fr@gmail.com", "rosso");
		Transaction trans = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(utente);
			trans.commit();
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
	}

}
