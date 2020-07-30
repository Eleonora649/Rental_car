package it.rentalcar.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Ruolo;
import it.rentalcar.util.HibernateUtil;

public class RuoloDao {
	
	public RuoloDao() {
	}
	
	public void persist(Ruolo ruolo) throws HibernateException{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction(); 
			session.save(ruolo); 
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
		}
	}
	
}
