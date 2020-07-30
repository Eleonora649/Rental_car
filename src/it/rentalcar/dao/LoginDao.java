package it.rentalcar.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Utente;
import it.rentalcar.util.HibernateUtil;

public class LoginDao {
	
	public Utente findUserByEmail(String email) {
		Transaction transaction = null;
		Utente user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = (Utente) session.createQuery("SELECT u FROM Utente u WHERE u.email=:email")
					.setParameter("email", email).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
		
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//			Query query = session.createQuery("SELECT u FROM Utente u WHERE u.email=:email AND u.password=:password");
//			Utente utente = (Utente) query.getSingleResult();
//			
//			transaction.commit();
//			return utente;
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			} e.printStackTrace();
//			return null;
//		}
//	}
}
