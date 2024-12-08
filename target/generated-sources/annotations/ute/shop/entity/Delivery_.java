package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.util.Date;

@StaticMetamodel(Delivery.class)
public abstract class Delivery_ {

	public static final String CREATED_AT = "createdAt";
	public static final String IS_DELETED = "isDeleted";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String QUERY_DELIVERY_FIND_ALL = "Delivery.findAll";
	public static final String _ID = "_id";
	public static final String UPDATED_AT = "updatedAt";
	public static final String ORDER = "order";

	
	/**
	 * @see ute.shop.entity.Delivery#createdAt
	 **/
	public static volatile SingularAttribute<Delivery, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Delivery#isDeleted
	 **/
	public static volatile SingularAttribute<Delivery, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.Delivery#price
	 **/
	public static volatile SingularAttribute<Delivery, BigDecimal> price;
	
	/**
	 * @see ute.shop.entity.Delivery#name
	 **/
	public static volatile SingularAttribute<Delivery, String> name;
	
	/**
	 * @see ute.shop.entity.Delivery#description
	 **/
	public static volatile SingularAttribute<Delivery, String> description;
	
	/**
	 * @see ute.shop.entity.Delivery#_id
	 **/
	public static volatile SingularAttribute<Delivery, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Delivery
	 **/
	public static volatile EntityType<Delivery> class_;
	
	/**
	 * @see ute.shop.entity.Delivery#updatedAt
	 **/
	public static volatile SingularAttribute<Delivery, Date> updatedAt;
	
	/**
	 * @see ute.shop.entity.Delivery#order
	 **/
	public static volatile SingularAttribute<Delivery, Order> order;

}

