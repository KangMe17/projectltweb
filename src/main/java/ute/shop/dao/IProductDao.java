package ute.shop.dao;

import java.util.List;

import ute.shop.entity.Product;

public interface IProductDao {

	
	//@dmhisdmh admin
	List<Product> findAll();
}
