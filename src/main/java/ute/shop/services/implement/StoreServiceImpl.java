package ute.shop.services.implement;

import java.util.List;

import ute.shop.entity.Store;
import ute.shop.services.IStoreService;
import ute.shop.dao.IStoreDao;
import ute.shop.dao.implement.StoreDaoImpl;

public class StoreServiceImpl implements IStoreService{

	IStoreDao storeDao = new StoreDaoImpl();
	
	@Override
	public List<Store> findAll() {
		return storeDao.findAll();
	}

}
