package it.rentalcar.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.mysql.cj.util.StringUtils;

import it.rentalcar.dao.PrenotazioneDao;
import it.rentalcar.dao.UtenteDao;
import it.rentalcar.model.Automobile;
import it.rentalcar.model.Prenotazione;
import it.rentalcar.model.Utente;

public class PrenotazioneService {
	private static PrenotazioneDao prenotazioneDao;
	private static SessionFactory sessionFactory;
	
	public PrenotazioneService() {
		prenotazioneDao = new PrenotazioneDao();
	}
	
	public Prenotazione persist(String inizioPrenotazione, String finePrenotazione, String utente, String automobile) throws NullPointerException {
		Prenotazione prenotazione = null;
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date inizioPren, finePren = null;
		try {
			inizioPren = dateFormat.parse(inizioPrenotazione);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new NullPointerException();
		} 
		final DateFormat dataFormat1 = new SimpleDateFormat("yyyy-MM-dd");;
		try {
			finePren = dataFormat1.parse(finePrenotazione);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		UtenteService userS = new UtenteService();
		int idUtente=Integer.parseInt(utente);
		Utente user = userS.findUtenteId(idUtente);
		
		AutomobileService autoS = new AutomobileService();
		int idAutomobile = Integer.parseInt(automobile);
		Automobile auto = autoS.findAutomobileId(idAutomobile);
		
		if(!StringUtils.isNullOrEmpty(inizioPrenotazione) && !StringUtils.isNullOrEmpty(finePrenotazione)) {
			try {
				prenotazione = new Prenotazione(inizioPren, finePren, user, auto);
				prenotazioneDao.persist(prenotazione);
			} catch (HibernateException e) {
				throw e;
			} catch (Exception e) {
				e.printStackTrace();
				throw new NullPointerException();
			}
		} else {
			throw new NullPointerException();
		}
		return prenotazione;
	}

	public List<Prenotazione> listAll() {
		List<Prenotazione> prenotazione = null; 
		if (sessionFactory == null) {
			prenotazione = prenotazioneDao.findAll();
		}
		return prenotazione;
	}

	public Prenotazione findPrenotazioneId(int id) {
		Prenotazione prenotazione = null;
		if (sessionFactory == null){
			prenotazione = prenotazioneDao.findPrenotazioneId(id);
		}
		return prenotazione;
	}

	public void delete(int id) {
		prenotazioneDao.delete(id);
	}

	public Prenotazione update(int id, String inizioPrenotazione, String finePrenotazione, String utente, String automobile) throws NullPointerException {
			Prenotazione p = (Prenotazione) prenotazioneDao.findPrenotazioneId(id);
			final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date inizioPren = null;
			try {
				inizioPren = dateFormat.parse(inizioPrenotazione);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new NullPointerException();
			}
			if(p!=null) {
				try {
//					p.setInizioPrenotazione(inizioPrenotazione);
//					p.setFinePrenotazione(finePrenotazione);
//					p.setUtente(utente);
//					p.setAutomobile(automobile);
					
					prenotazioneDao.updatePrenotazione(p);

				} catch (Exception e) {
					e.printStackTrace();
					throw new NullPointerException();
				}
			}
		return p;
	}
}
	
	

