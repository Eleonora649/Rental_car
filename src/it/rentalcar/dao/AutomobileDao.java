package it.rentalcar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import it.rentalcar.model.Automobile;

public class AutomobileDao {

	private Session currentSession;
	private Transaction currentTransaction;
	
	public AutomobileDao() {
	}
	
	public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    public void persist(Automobile entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Automobile entity) {
        getCurrentSession().update(entity);
    }
 
    public Automobile findById(String id) {
        Automobile auto = (Automobile) getCurrentSession().get(Automobile.class, id);
        return auto; 
    }
 
    public void delete(Automobile entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Automobile> findAll() {
        List<Automobile> auto = (List<Automobile>) getCurrentSession().createQuery("from automobile").list();
        return auto;
    }
 
    public void deleteAll() {
        List<Automobile> entityList = findAll();
        for (Automobile entity : entityList) {
            delete(entity);
        }
    }


}
