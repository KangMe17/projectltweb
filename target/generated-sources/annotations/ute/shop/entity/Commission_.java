package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Commission.class)
public abstract class Commission_ {

	public static final String CREATED_AT = "createdAt";
	public static final String COST = "cost";
	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String QUERY_COMMISSION_FIND_ALL = "Commission.findAll";
	public static final String DESCRIPTION = "description";
	public static final String ORDERS = "orders";
	public static final String _ID = "_id";
	public static final String STORE = "store";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Commission#createdAt
	 **/
	public static volatile SingularAttribute<Commission, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Commission#cost
	 **/
	public static volatile SingularAttribute<Commission, Double> cost;
	
	/**
	 * @see ute.shop.entity.Commission#isDeleted
	 **/
	public static volatile SingularAttribute<Commission, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.Commission#name
	 **/
	public static volatile SingularAttribute<Commission, String> name;
	
	/**
	 * @see ute.shop.entity.Commission#description
	 **/
	public static volatile SingularAttribute<Commission, String> description;
	
	/**
	 * @see ute.shop.entity.Commission#orders
	 **/
	public static volatile ListAttribute<Commission, Order> orders;
	
	/**
	 * @see ute.shop.entity.Commission#_id
	 **/
	public static volatile SingularAttribute<Commission, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Commission#store
	 **/
	public static volatile SingularAttribute<Commission, Store> store;
	
	/**
	 * @see ute.shop.entity.Commission
	 **/
	public static volatile EntityType<Commission> class_;
	
	/**
	 * @see ute.shop.entity.Commission#updatedAt
	 **/
	public static volatile SingularAttribute<Commission, Date> updatedAt;

}

