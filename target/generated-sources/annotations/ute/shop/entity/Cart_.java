package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Cart.class)
public abstract class Cart_ {

	public static final String CREATED_AT = "createdAt";
	public static final String _ID = "_id";
	public static final String STORE = "store";
	public static final String QUERY_CART_FIND_ALL = "Cart.findAll";
	public static final String CART_ITEMS = "cartItems";
	public static final String USER = "user";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Cart#createdAt
	 **/
	public static volatile SingularAttribute<Cart, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Cart#_id
	 **/
	public static volatile SingularAttribute<Cart, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Cart#store
	 **/
	public static volatile SingularAttribute<Cart, Store> store;
	
	/**
	 * @see ute.shop.entity.Cart#cartItems
	 **/
	public static volatile ListAttribute<Cart, CartItem> cartItems;
	
	/**
	 * @see ute.shop.entity.Cart
	 **/
	public static volatile EntityType<Cart> class_;
	
	/**
	 * @see ute.shop.entity.Cart#user
	 **/
	public static volatile SingularAttribute<Cart, User> user;
	
	/**
	 * @see ute.shop.entity.Cart#updatedAt
	 **/
	public static volatile SingularAttribute<Cart, Date> updatedAt;

}

