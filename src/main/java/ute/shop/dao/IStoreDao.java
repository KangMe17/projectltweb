package ute.shop.dao;

import java.util.List;

import ute.shop.entity.Store;

public interface IStoreDao {
	Store findById(int storeId);

	Store findByOrderId(int orderId);
	
	List<Store> findAll();

	Integer findStoreIdByUserId(int user_id);
}
