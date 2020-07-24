package it.rentalcar.service;

import java.util.List;

import it.rentalcar.dao.AutomobileDao;
import it.rentalcar.model.Automobile;

public class AutomobileService {

	private static AutomobileDao autoDao;

	public AutomobileService() {
		autoDao = new AutomobileDao();
	}

	public void persist(Automobile entity) {
		if(entity.getModello() != null) 
		{
			autoDao.persist(entity);
		}
//		autoDao.openCurrentSessionwithTransaction();
//		autoDao.persist(entity);
//		autoDao.closeCurrentSessionwithTransaction();
	}

	public void update(Automobile entity) {
		autoDao.openCurrentSessionwithTransaction();
		autoDao.update(entity);
		autoDao.closeCurrentSessionwithTransaction();
	}

	public Automobile findById(String id) {
		autoDao.openCurrentSession();
		Automobile auto = autoDao.findById(id);
		autoDao.closeCurrentSession();
		return auto;
	}

	public void delete(String id) {
		autoDao.openCurrentSessionwithTransaction();
		Automobile auto = autoDao.findById(id);
		autoDao.delete(auto);
		autoDao.closeCurrentSessionwithTransaction();
	}

	public List<Automobile> findAll() {
		autoDao.openCurrentSession();
		List<Automobile> automobili = autoDao.findAll();
		autoDao.closeCurrentSession();
		return automobili;
	}

	public void deleteAll() {
		autoDao.openCurrentSessionwithTransaction();
		autoDao.deleteAll();
		autoDao.closeCurrentSessionwithTransaction();
	}

	public AutomobileDao autoDao() {
		return autoDao;
	}
}
