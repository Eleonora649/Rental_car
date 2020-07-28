package it.rentalcar.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.mysql.cj.util.StringUtils;

import it.rentalcar.dao.AutomobileDao;
import it.rentalcar.model.Automobile;
import it.rentalcar.model.Categoria;

public class AutomobileService {
	private static AutomobileDao autoDao;
	private static SessionFactory sessionFactory;

	public AutomobileService() {
		autoDao = new AutomobileDao();
	}

	public Automobile persist(String modello, String targa, String casaCostruttrice, String annoImm, String categoria) {
		Automobile auto = null;
		int anno = Integer.parseInt(annoImm);
		
		int idCategoria=Integer.parseInt(categoria);
		Categoria cat = autoDao.findCategoriaId(idCategoria);
		
		 if(!StringUtils.isNullOrEmpty(targa)) {
			try {
				auto = new Automobile(modello, targa, casaCostruttrice, anno, cat);
				autoDao.persist(auto);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new NullPointerException();
			}
		}
		return auto;
	}

	public Categoria findCategoriaId(int id) {
		Categoria cat = null;
		if (sessionFactory == null){
			cat = autoDao.findCategoriaId(id);
		}
		return cat;
	}

	public List<Automobile> listAll() {
		List<Automobile> auto = null; 
		if (sessionFactory == null) {
			auto = autoDao.findAll();
		}
		return auto;
	}

	public Automobile findAutomobileId(int id) {
		Automobile auto = null;
		if (sessionFactory == null){
			auto = autoDao.findAutomobileId(id);
		}

		return auto;
	}
	
	public void delete(int id) {
		Automobile auto = autoDao.delete(id);
	}

	public Automobile update(int id, String modello, String targa, String casaCostruttrice, String annoImm, String categoria) throws NullPointerException {
		Automobile auto = (Automobile) autoDao.findAutomobileId(id);
		
		int anno = Integer.parseInt(annoImm);
		int idCategoria = Integer.parseInt(categoria);
		Categoria cat = autoDao.findCategoriaId(idCategoria);

		if(auto!=null) {
			try {
				auto.setModello(modello);
				auto.setTarga(targa);
				auto.setCasaCostruttrice(casaCostruttrice);
				auto.setAnnoImmatricolazione(anno);
				auto.setCategoria(cat);
				
				autoDao.updateAutomobile(auto);
			} catch (Exception e) {
				e.printStackTrace();
				throw new NullPointerException();
			}
		}
			return auto;
	}

	
}
