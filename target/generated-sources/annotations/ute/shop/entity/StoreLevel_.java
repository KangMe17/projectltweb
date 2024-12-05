package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(StoreLevel.class)
public abstract class StoreLevel_ {

	public static final String MIN_POINT = "minPoint";
	public static final String CREATED_AT = "createdAt";
	public static final String IS_DELETED = "isDeleted";
	public static final String QUERY_STORE_LEVEL_FIND_ALL = "StoreLevel.findAll";
	public static final String NAME = "name";
	public static final String DISCOUNT = "discount";
	public static final String _ID = "_id";
	public static final String STORE = "store";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.StoreLevel#minPoint
	 **/
	public static volatile SingularAttribute<StoreLevel, Integer> minPoint;
	
	/**
	 * @see ute.shop.entity.StoreLevel#createdAt
	 **/
	public static volatile SingularAttribute<StoreLevel, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.StoreLevel#isDeleted
	 **/
	public static volatile SingularAttribute<StoreLevel, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.StoreLevel#name
	 **/
	public static volatile SingularAttribute<StoreLevel, String> name;
	
	/**
	 * @see ute.shop.entity.StoreLevel#discount
	 **/
	public static volatile SingularAttribute<StoreLevel, Double> discount;
	
	/**
	 * @see ute.shop.entity.StoreLevel#_id
	 **/
	public static volatile SingularAttribute<StoreLevel, Integer> _id;
	
	/**
	 * @see ute.shop.entity.StoreLevel#store
	 **/
	public static volatile SingularAttribute<StoreLevel, Store> store;
	
	/**
	 * @see ute.shop.entity.StoreLevel
	 **/
	public static volatile EntityType<StoreLevel> class_;
	
	/**
	 * @see ute.shop.entity.StoreLevel#updatedAt
	 **/
	public static volatile SingularAttribute<StoreLevel, Date> updatedAt;

}

