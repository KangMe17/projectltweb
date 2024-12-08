package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static final String DELIVERY = "delivery";
	public static final String AMOUNT_TO_GD = "amountToGD";
	public static final String ADDRESS = "address";
	public static final String AMOUNT_FROM_STORE = "amountFromStore";
	public static final String STORE = "store";
	public static final String ORDER_ITEMS = "orderItems";
	public static final String QUERY_ORDER_FIND_ALL = "Order.findAll";
	public static final String IS_PAID_BEFORE = "isPaidBefore";
	public static final String CREATED_AT = "createdAt";
	public static final String REVIEWS = "reviews";
	public static final String PHONE = "phone";
	public static final String AMOUNT_FROM_USER = "amountFromUser";
	public static final String COMMISSION = "commission";
	public static final String _ID = "_id";
	public static final String USER = "user";
	public static final String AMOUNT_TO_STORE = "amountToStore";
	public static final String STATUS = "status";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Order#delivery
	 **/
	public static volatile SingularAttribute<Order, Delivery> delivery;
	
	/**
	 * @see ute.shop.entity.Order#amountToGD
	 **/
	public static volatile SingularAttribute<Order, Double> amountToGD;
	
	/**
	 * @see ute.shop.entity.Order#address
	 **/
	public static volatile SingularAttribute<Order, String> address;
	
	/**
	 * @see ute.shop.entity.Order#amountFromStore
	 **/
	public static volatile SingularAttribute<Order, Double> amountFromStore;
	
	/**
	 * @see ute.shop.entity.Order#store
	 **/
	public static volatile SingularAttribute<Order, Store> store;
	
	/**
	 * @see ute.shop.entity.Order#orderItems
	 **/
	public static volatile ListAttribute<Order, OrderItem> orderItems;
	
	/**
	 * @see ute.shop.entity.Order#isPaidBefore
	 **/
	public static volatile SingularAttribute<Order, Boolean> isPaidBefore;
	
	/**
	 * @see ute.shop.entity.Order#createdAt
	 **/
	public static volatile SingularAttribute<Order, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Order#reviews
	 **/
	public static volatile ListAttribute<Order, Review> reviews;
	
	/**
	 * @see ute.shop.entity.Order#phone
	 **/
	public static volatile SingularAttribute<Order, String> phone;
	
	/**
	 * @see ute.shop.entity.Order#amountFromUser
	 **/
	public static volatile SingularAttribute<Order, Double> amountFromUser;
	
	/**
	 * @see ute.shop.entity.Order#commission
	 **/
	public static volatile SingularAttribute<Order, Commission> commission;
	
	/**
	 * @see ute.shop.entity.Order#_id
	 **/
	public static volatile SingularAttribute<Order, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Order
	 **/
	public static volatile EntityType<Order> class_;
	
	/**
	 * @see ute.shop.entity.Order#user
	 **/
	public static volatile SingularAttribute<Order, User> user;
	
	/**
	 * @see ute.shop.entity.Order#amountToStore
	 **/
	public static volatile SingularAttribute<Order, Double> amountToStore;
	
	/**
	 * @see ute.shop.entity.Order#status
	 **/
	public static volatile SingularAttribute<Order, OrderStatus> status;
	
	/**
	 * @see ute.shop.entity.Order#updatedAt
	 **/
	public static volatile SingularAttribute<Order, Date> updatedAt;

}

