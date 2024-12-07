package ute.shop.services.implement;

import ute.shop.dao.IStoreDao;
import ute.shop.dao.implement.StoreDaoImpl;
import ute.shop.entity.Store;
import ute.shop.services.IStoreService;

public class StoreServiceImpl implements IStoreService {

	IStoreDao storeDao = new StoreDaoImpl();

	@Override
	public Store findById(int storeId) {
		try {
			return storeDao.findById(storeId);
		} catch (Exception e) {
			throw new RuntimeException("Error finding order by ID: " + storeId, e);
		}
	}

	@Override
	public Store getStoreByOrder(int orderId) {
		try {
			return storeDao.findByOrderId(orderId);
		} catch (Exception e) {
			throw new RuntimeException("Error finding store by order ID: " + orderId, e);
		}
	}

}
