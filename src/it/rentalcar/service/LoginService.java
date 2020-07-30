package it.rentalcar.service;

import it.rentalcar.dao.LoginDao;
import it.rentalcar.model.Utente;

public class LoginService {
	private static LoginDao logindao;

	public Utente authenticate(String email, String password) {
		logindao = new LoginDao();
		Utente utente = logindao.findUserByEmail(email);
		System.out.println(utente.getEmail());

		if (!(utente != null && utente.getEmail().equals(email) 
				&& utente.getPassword().equals(password))) {
			utente = null;
			//throw new Exception("Login not successful..");
		}
		return utente;
	}
}
//	public Utente findUtenteEmail(String email) {
//		Utente utente = null;
//		sessionFactory.getProperties("email");
//		if (sessionFactory == null){
//			if(utente.getEmail().equals(email)) {
//				utente = userDao.findUtenteEmail(email);
//			}
//			return utente;
//		} else {
//			System.out.println("Errore");
//			return null;
//		}
//	}

