package ute.shop.dao;

import ute.shop.entity.Store;

public interface IStoreDao {
	Store findById(int storeId);

	Store findByOrderId(int orderId);
}
