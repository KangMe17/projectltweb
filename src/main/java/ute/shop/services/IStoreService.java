package ute.shop.services;


import ute.shop.entity.Store;
import java.util.List;

public interface IStoreService {

	Store findById(int storeId);

	Store getStoreByOrder(int orderId);
	List<Store> findAll();
}


