package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(CartItem.class)
public abstract class CartItem_ {

	public static final String CREATED_AT = "createdAt";
	public static final String PRODUCT = "product";
	public static final String STYLE_VALUE = "styleValue";
	public static final String STYLE_VALUE_IDS = "styleValueIds";
	public static final String QUERY_CART_ITEM_FIND_ALL = "CartItem.findAll";
	public static final String COUNT = "count";
	public static final String _ID = "_id";
	public static final String CART = "cart";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.CartItem#createdAt
	 **/
	public static volatile SingularAttribute<CartItem, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.CartItem#product
	 **/
	public static volatile SingularAttribute<CartItem, Product> product;
	
	/**
	 * @see ute.shop.entity.CartItem#styleValue
	 **/
	public static volatile SingularAttribute<CartItem, StyleValue> styleValue;
	
	/**
	 * @see ute.shop.entity.CartItem#styleValueIds
	 **/
	public static volatile ListAttribute<CartItem, String> styleValueIds;
	
	/**
	 * @see ute.shop.entity.CartItem#count
	 **/
	public static volatile SingularAttribute<CartItem, Integer> count;
	
	/**
	 * @see ute.shop.entity.CartItem#_id
	 **/
	public static volatile SingularAttribute<CartItem, Integer> _id;
	
	/**
	 * @see ute.shop.entity.CartItem
	 **/
	public static volatile EntityType<CartItem> class_;
	
	/**
	 * @see ute.shop.entity.CartItem#cart
	 **/
	public static volatile SingularAttribute<CartItem, Cart> cart;
	
	/**
	 * @see ute.shop.entity.CartItem#updatedAt
	 **/
	public static volatile SingularAttribute<CartItem, Date> updatedAt;

}

