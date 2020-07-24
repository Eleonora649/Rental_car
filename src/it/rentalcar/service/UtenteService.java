package it.rentalcar.service;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.cj.util.StringUtils;

import it.rentalcar.dao.UtenteDao;
import it.rentalcar.model.Utente;
import it.rentalcar.util.HibernateUtil;

public class UtenteService {

	private static UtenteDao userDao;
	private static SessionFactory sessionFactory;

	public UtenteService() {
		userDao = new UtenteDao();
	}

	public Utente persist(String nome, String cognome, String data, String email, String password) throws NullPointerException {
		Utente user = null;
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;
		try {
			birthDate = dateFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new NullPointerException();
		} if(!StringUtils.isNullOrEmpty(email)) {
			try {
				user = new Utente(nome, cognome, birthDate, email, password);
				userDao.persist(user);
			} catch (HibernateException e) {
				throw e;
			} catch (Exception e) {
				e.printStackTrace();
				throw new NullPointerException();
			}
		} else {
			throw new NullPointerException();
		}
		return user;
	}

	public List<Utente> listAll() {
//		return (List<Utente>) userDao.findAll();
		List<Utente> users = null; 
		if (sessionFactory == null) {
			users = userDao.findAll();
		}
		return users;
	}

	public Utente findUtenteId(int id) {
		Utente utente = null;
		if (sessionFactory == null){
			utente = userDao.findUtenteId(id);
        }
			
		return utente;
	}

	public void delete(int id) {
		Utente utente = userDao.delete(id);
	}

	public void update(int id, Utente utente) {
		
		userDao.updateUtente(utente);
	}

}
