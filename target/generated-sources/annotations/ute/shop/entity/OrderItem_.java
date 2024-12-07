package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(OrderItem.class)
public abstract class OrderItem_ {

	public static final String CREATED_AT = "createdAt";
	public static final String PRODUCT = "product";
	public static final String STYLE_VALUE_IDS = "styleValueIds";
	public static final String COUNT = "count";
	public static final String _ID = "_id";
	public static final String QUERY_ORDER_ITEM_FIND_ALL = "OrderItem.findAll";
	public static final String ORDER = "order";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.OrderItem#createdAt
	 **/
	public static volatile SingularAttribute<OrderItem, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.OrderItem#product
	 **/
	public static volatile SingularAttribute<OrderItem, Product> product;
	
	/**
	 * @see ute.shop.entity.OrderItem#styleValueIds
	 **/
	public static volatile ListAttribute<OrderItem, String> styleValueIds;
	
	/**
	 * @see ute.shop.entity.OrderItem#count
	 **/
	public static volatile SingularAttribute<OrderItem, Integer> count;
	
	/**
	 * @see ute.shop.entity.OrderItem#_id
	 **/
	public static volatile SingularAttribute<OrderItem, Integer> _id;
	
	/**
	 * @see ute.shop.entity.OrderItem
	 **/
	public static volatile EntityType<OrderItem> class_;
	
	/**
	 * @see ute.shop.entity.OrderItem#order
	 **/
	public static volatile SingularAttribute<OrderItem, Order> order;
	
	/**
	 * @see ute.shop.entity.OrderItem#updatedAt
	 **/
	public static volatile SingularAttribute<OrderItem, Date> updatedAt;

}

