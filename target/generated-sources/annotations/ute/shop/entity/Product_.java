package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static final String SOLD = "sold";
	public static final String QUANTITY = "quantity";
	public static final String STYLE_VALUE_IDS = "styleValueIds";
	public static final String PROMOTIONAL_PRICE = "promotionalPrice";
	public static final String RATING = "rating";
	public static final String DESCRIPTION = "description";
	public static final String STYLE_VALUES = "styleValues";
	public static final String STORE = "store";
	public static final String IS_ACTIVE = "isActive";
	public static final String USER_FOLLOW_PRODUCTS = "userFollowProducts";
	public static final String ORDER_ITEMS = "orderItems";
	public static final String LIST_IMAGES = "listImages";
	public static final String CREATED_AT = "createdAt";
	public static final String REVIEWS = "reviews";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String QUERY_PRODUCT_FIND_ALL = "Product.findAll";
	public static final String _ID = "_id";
	public static final String CATEGORY = "category";
	public static final String CART_ITEMS = "cartItems";
	public static final String IS_SELLING = "isSelling";
	public static final String SLUG = "slug";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Product#sold
	 **/
	public static volatile SingularAttribute<Product, Integer> sold;
	
	/**
	 * @see ute.shop.entity.Product#quantity
	 **/
	public static volatile SingularAttribute<Product, Integer> quantity;
	
	/**
	 * @see ute.shop.entity.Product#styleValueIds
	 **/
	public static volatile ListAttribute<Product, String> styleValueIds;
	
	/**
	 * @see ute.shop.entity.Product#promotionalPrice
	 **/
	public static volatile SingularAttribute<Product, Double> promotionalPrice;
	
	/**
	 * @see ute.shop.entity.Product#rating
	 **/
	public static volatile SingularAttribute<Product, Integer> rating;
	
	/**
	 * @see ute.shop.entity.Product#description
	 **/
	public static volatile SingularAttribute<Product, String> description;
	
	/**
	 * @see ute.shop.entity.Product#styleValues
	 **/
	public static volatile ListAttribute<Product, StyleValue> styleValues;
	
	/**
	 * @see ute.shop.entity.Product#store
	 **/
	public static volatile SingularAttribute<Product, Store> store;
	
	/**
	 * @see ute.shop.entity.Product#isActive
	 **/
	public static volatile SingularAttribute<Product, Boolean> isActive;
	
	/**
	 * @see ute.shop.entity.Product#userFollowProducts
	 **/
	public static volatile ListAttribute<Product, UserFollowProduct> userFollowProducts;
	
	/**
	 * @see ute.shop.entity.Product#orderItems
	 **/
	public static volatile ListAttribute<Product, OrderItem> orderItems;
	
	/**
	 * @see ute.shop.entity.Product#listImages
	 **/
	public static volatile ListAttribute<Product, String> listImages;
	
	/**
	 * @see ute.shop.entity.Product#createdAt
	 **/
	public static volatile SingularAttribute<Product, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Product#reviews
	 **/
	public static volatile ListAttribute<Product, Review> reviews;
	
	/**
	 * @see ute.shop.entity.Product#price
	 **/
	public static volatile SingularAttribute<Product, Double> price;
	
	/**
	 * @see ute.shop.entity.Product#name
	 **/
	public static volatile SingularAttribute<Product, String> name;
	
	/**
	 * @see ute.shop.entity.Product#_id
	 **/
	public static volatile SingularAttribute<Product, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Product#category
	 **/
	public static volatile SingularAttribute<Product, Category> category;
	
	/**
	 * @see ute.shop.entity.Product#cartItems
	 **/
	public static volatile ListAttribute<Product, CartItem> cartItems;
	
	/**
	 * @see ute.shop.entity.Product
	 **/
	public static volatile EntityType<Product> class_;
	
	/**
	 * @see ute.shop.entity.Product#isSelling
	 **/
	public static volatile SingularAttribute<Product, Boolean> isSelling;
	
	/**
	 * @see ute.shop.entity.Product#slug
	 **/
	public static volatile SingularAttribute<Product, String> slug;
	
	/**
	 * @see ute.shop.entity.Product#updatedAt
	 **/
	public static volatile SingularAttribute<Product, Date> updatedAt;

}

