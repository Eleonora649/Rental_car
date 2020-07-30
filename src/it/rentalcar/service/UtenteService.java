package it.rentalcar.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.mysql.cj.util.StringUtils;

import it.rentalcar.dao.UtenteDao;
import it.rentalcar.model.Utente;

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
		userDao.delete(id);
	}

	public Utente update(int id, String nome, String cognome, String data, String email, String password) throws NullPointerException {
			Utente u = (Utente) userDao.findUtenteId(id);
			final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate = null;
			try {
				birthDate = dateFormat.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new NullPointerException();
			}
			if(u!=null) {
				try {
					u.setNome(nome);
					u.setCognome(cognome);
					u.setDataDiNascita(birthDate);
					u.setEmail(email);
					u.setPassword(password);
					
					userDao.updateUtente(u);

				} catch (Exception e) {
					e.printStackTrace();
					throw new NullPointerException();
				}
			}
		return u;
	}

	public Utente findUtente(String email, String password) {
		return null;
	}
	
	public Utente ritornaDati(int id) { 
		Utente utente = (Utente) userDao.ritornaDati(id);
		utente.getNome();
		utente.getCognome();
		utente.getDataDiNascita();
		utente.getEmail();
		utente.getPassword();
		System.out.println(utente.getNome() +" "+ utente.getCognome());
		System.out.println(utente.getEmail() +" "+ utente.getDataDiNascita());
		return utente; 
	}
	 
}