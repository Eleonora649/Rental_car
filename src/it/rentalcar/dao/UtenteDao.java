package it.rentalcar.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Utente;
import it.rentalcar.util.HibernateUtil;

public class UtenteDao {

	public UtenteDao() {
	}

	public void persist(Utente entity) throws HibernateException{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction(); // start a transaction
			session.save(entity); // save the entity object
			transaction.commit(); // commit transaction

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
		}
	}

	public List<Utente> findAll() {
		Transaction transaction = null;
		List<Utente> users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery("Utente.findAll");
			users = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}	

	public Utente delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Utente utente = findUtenteId(id);
			session.remove(utente);

			transaction.commit();
			return utente;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}
	}

	public Utente findUtenteId(int id) {
		Transaction transaction = null;
		//Utente utente = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Utente utente = session.find(Utente.class, id); //session.byId(Utente.class).getReference(id);
			System.out.println(utente.getNome() +" "+ utente.getCognome());
			System.out.println(utente.getEmail());

			transaction.commit();
			return utente;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}
		//return utente;
	}

	public void updateUtente (Utente utente) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(utente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Utente ritornaDati (int id) { 
		Transaction transaction = null; 
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
			transaction = session.beginTransaction();
//			Utente u = (Utente) getCurrentSession().get(Utente.class, id);
			
			Utente utente = session.find(Utente.class, id);
//			Query query = session.createQuery("SELECT * FROM utente WHERE id_utente = getParameter("id");
//			utente = (Utente) query.getResultList(); 
			transaction.commit(); 
			return utente;
		} catch (Exception e) { 
			e.printStackTrace(); 
			return null;
		} 
		 
	}
	 
}