package it.rentalcar.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.rentalcar.model.Automobile;
import it.rentalcar.model.Categoria;
import it.rentalcar.util.HibernateUtil;

public class AutomobileDao {
	private Session currentSession;
	private Transaction currentTransaction;

	public AutomobileDao() {
	}

	public void persist(Automobile auto) throws HibernateException{
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction(); 
			session.save(auto); 
			transaction.commit(); 

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
		}
	}

	public Categoria findCategoriaId(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Categoria cat =(Categoria) session.find(Categoria.class, id); 
			System.out.println(cat.getNome());

			transaction.commit();
			return cat;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}
	}

	public List<Automobile> findAll() {
		Transaction transaction = null;
		List<Automobile> auto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createNamedQuery("Automobile.findAll");
			auto = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auto;
	}	
	
	public Automobile delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Automobile auto = findAutomobileId(id);
			session.remove(auto);

			transaction.commit();
			return auto;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}
	}

	public Automobile findAutomobileId(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			Automobile auto = session.find(Automobile.class, id); 
			System.out.println(auto.getModello() +" "+ auto.getTarga());

			transaction.commit();
			return auto;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			} e.printStackTrace();
			return null;
		}
	}
	
	public void updateAutomobile(Automobile auto) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(auto);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}


