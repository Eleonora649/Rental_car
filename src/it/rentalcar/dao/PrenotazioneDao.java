package it.rentalcar.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Automobile;
import it.rentalcar.model.Prenotazione;
import it.rentalcar.model.Utente;
import it.rentalcar.service.AutomobileService;
import it.rentalcar.service.UtenteService;
import it.rentalcar.util.HibernateUtil;

public class PrenotazioneDao {
	
	public PrenotazioneDao() {
	}
	
	public void persist(Prenotazione entity) throws HibernateException{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction(); 
			session.save(entity); 
			transaction.commit(); 
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
		}
	}

	public List<Prenotazione> findAll() {
		Transaction transaction = null;
		List<Prenotazione> prenotazione = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery("Prenotazione.findAll");
			prenotazione = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prenotazione;
	}	
	
	public Prenotazione delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Prenotazione prenotazione = findPrenotazioneId(id);
			session.remove(prenotazione);

			transaction.commit();
			return prenotazione;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}
	}
	
	public Prenotazione findPrenotazioneId(int id) {
		Transaction transaction = null;
		Prenotazione pren = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			pren = session.find(Prenotazione.class, id); 
//			System.out.println(prenotazione.getInizioPrenotazione() +" "+ prenotazione.getFinePrenotazione());
			transaction.commit();
			return pren;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}

	}

	public void updatePrenotazione (Prenotazione entity) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Utente findUtenteId(int id) {
		
		UtenteService utenteS = new UtenteService();
		Utente utente = utenteS.findUtenteId(id);
		return utente;
		
	}

	public Automobile findAutomobileId(int id) {
		
		AutomobileService autoS = new AutomobileService();
		Automobile auto = autoS.findAutomobileId(id);
		return auto;
	}
	
	public Automobile findAutomobileById(int id) {
		Transaction transaction = null;
		Automobile auto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			auto = (Automobile) session.createQuery("SELECT * FROM Prenotazione p WHERE p.fine_prenotazione=:finePrenotazione and id_automobile=:idAutomobile")
					.setParameter("idAuto", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return auto;
	}
	
}
