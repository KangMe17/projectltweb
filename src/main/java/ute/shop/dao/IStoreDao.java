package ute.shop.dao;

import java.util.List;

import ute.shop.entity.Store;

public interface IStoreDao {

	List<Store> findAll();
}
