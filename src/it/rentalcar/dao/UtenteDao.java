package it.rentalcar.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import it.rentalcar.model.Utente;
import it.rentalcar.util.HibernateUtil;

public class UtenteDao {
	

	public UtenteDao() {
	}

	public void persist(Utente entity) throws HibernateException{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction(); // start a transaction
			session.save(entity); // save the student object
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
	/*
	 * public void update(int id, Utente entity) { Transaction transaction = null;
	 * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	 * 
	 * Utente utente = session.get(Utente.class, id); if(utente != null){
	 * transaction = session.beginTransaction(); session.merge(utente);
	 * transaction.commit(); } // Utente utente = findUtenteId(id); //
	 * session.merge(utente); } catch (Exception e) { if (transaction != null) {
	 * transaction.rollback(); } e.printStackTrace(); } }
	 */
	 
	
		//	public Session openCurrentSession() {
		//        currentSession = getSessionFactory().openSession();
		//        return currentSession;
		//    }
		// 
		//	public Session openCurrentSessionwithTransaction() {
		//        currentSession = getSessionFactory().openSession();
		//        currentTransaction = currentSession.beginTransaction();
		//        return currentSession;
		//    }
		//     
		//    public void closeCurrentSession() {
		//        currentSession.close();
		//    }
		//     
		//    public void closeCurrentSessionwithTransaction() {
		//        currentTransaction.commit();
		//        currentSession.close();
		//    }
		//     
		//    private static SessionFactory getSessionFactory() {
		//        Configuration configuration = new Configuration().configure();
		//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		//        return sessionFactory;
		//    }

		//    public Session getCurrentSession() {
		//        return currentSession;
		//    }
		// 
		//    public void setCurrentSession(Session currentSession) {
		//        this.currentSession = currentSession;
		//    }
		// 
		//    public Transaction getCurrentTransaction() {
		//        return currentTransaction;
		//    }
		// 
		//    public void setCurrentTransaction(Transaction currentTransaction) {
		//        this.currentTransaction = currentTransaction;
		//    }

		//    public Utente findById(String id) {
		//    	Utente user = (Utente) getCurrentSession().get(Utente.class, id);
		//        return user; 
		//    }
		// 
		// 
		//    public void deleteAll() {
		//        List<Utente> entityList = findAll();
		//        for (Utente entity : entityList) {
		//            delete(entity);
		//        }
		//    }
}