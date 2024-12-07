package ute.shop.services;

import ute.shop.entity.Store;

public interface IStoreService {

	Store findById(int storeId);

	Store getStoreByOrder(int orderId);

}
