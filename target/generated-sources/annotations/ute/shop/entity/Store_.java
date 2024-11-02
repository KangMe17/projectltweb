package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Store.class)
public abstract class Store_ {

	public static final String STORE_LEVEL = "storeLevel";
	public static final String QUERY_STORE_FIND_ALL = "Store.findAll";
	public static final String RATING = "rating";
	public static final String BIO = "bio";
	public static final String FEATURED_IMAGES = "featuredImages";
	public static final String IS_ACTIVE = "isActive";
	public static final String POINT = "point";
	public static final String PRODUCTS = "products";
	public static final String COVER = "cover";
	public static final String CREATED_AT = "createdAt";
	public static final String REVIEWS = "reviews";
	public static final String COMMISSION = "commission";
	public static final String SLUG = "slug";
	public static final String STAFFS = "staffs";
	public static final String UPDATED_AT = "updatedAt";
	public static final String OWNER = "owner";
	public static final String AVATAR = "avatar";
	public static final String TRANSACTIONS = "transactions";
	public static final String E_WALLET = "e_wallet";
	public static final String IS_OPEN = "isOpen";
	public static final String CARTS = "carts";
	public static final String FOLLOWERS = "followers";
	public static final String COMMISSION_SOLD = "commissionSold";
	public static final String NAME = "name";
	public static final String ORDERS = "orders";
	public static final String _ID = "_id";

	
	/**
	 * @see ute.shop.entity.Store#storeLevel
	 **/
	public static volatile SingularAttribute<Store, StoreLevel> storeLevel;
	
	/**
	 * @see ute.shop.entity.Store#rating
	 **/
	public static volatile SingularAttribute<Store, Double> rating;
	
	/**
	 * @see ute.shop.entity.Store#bio
	 **/
	public static volatile SingularAttribute<Store, String> bio;
	
	/**
	 * @see ute.shop.entity.Store#featuredImages
	 **/
	public static volatile ListAttribute<Store, String> featuredImages;
	
	/**
	 * @see ute.shop.entity.Store#isActive
	 **/
	public static volatile SingularAttribute<Store, Boolean> isActive;
	
	/**
	 * @see ute.shop.entity.Store#point
	 **/
	public static volatile SingularAttribute<Store, Integer> point;
	
	/**
	 * @see ute.shop.entity.Store#products
	 **/
	public static volatile ListAttribute<Store, Product> products;
	
	/**
	 * @see ute.shop.entity.Store#cover
	 **/
	public static volatile SingularAttribute<Store, String> cover;
	
	/**
	 * @see ute.shop.entity.Store#createdAt
	 **/
	public static volatile SingularAttribute<Store, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Store#reviews
	 **/
	public static volatile ListAttribute<Store, Review> reviews;
	
	/**
	 * @see ute.shop.entity.Store#commission
	 **/
	public static volatile SingularAttribute<Store, Commission> commission;
	
	/**
	 * @see ute.shop.entity.Store
	 **/
	public static volatile EntityType<Store> class_;
	
	/**
	 * @see ute.shop.entity.Store#slug
	 **/
	public static volatile SingularAttribute<Store, String> slug;
	
	/**
	 * @see ute.shop.entity.Store#staffs
	 **/
	public static volatile ListAttribute<Store, User> staffs;
	
	/**
	 * @see ute.shop.entity.Store#updatedAt
	 **/
	public static volatile SingularAttribute<Store, Date> updatedAt;
	
	/**
	 * @see ute.shop.entity.Store#owner
	 **/
	public static volatile SingularAttribute<Store, User> owner;
	
	/**
	 * @see ute.shop.entity.Store#avatar
	 **/
	public static volatile SingularAttribute<Store, String> avatar;
	
	/**
	 * @see ute.shop.entity.Store#transactions
	 **/
	public static volatile ListAttribute<Store, Transaction> transactions;
	
	/**
	 * @see ute.shop.entity.Store#e_wallet
	 **/
	public static volatile SingularAttribute<Store, Double> e_wallet;
	
	/**
	 * @see ute.shop.entity.Store#isOpen
	 **/
	public static volatile SingularAttribute<Store, Boolean> isOpen;
	
	/**
	 * @see ute.shop.entity.Store#carts
	 **/
	public static volatile ListAttribute<Store, Cart> carts;
	
	/**
	 * @see ute.shop.entity.Store#followers
	 **/
	public static volatile ListAttribute<Store, UserFollowStore> followers;
	
	/**
	 * @see ute.shop.entity.Store#commissionSold
	 **/
	public static volatile SingularAttribute<Store, Double> commissionSold;
	
	/**
	 * @see ute.shop.entity.Store#name
	 **/
	public static volatile SingularAttribute<Store, String> name;
	
	/**
	 * @see ute.shop.entity.Store#orders
	 **/
	public static volatile ListAttribute<Store, Order> orders;
	
	/**
	 * @see ute.shop.entity.Store#_id
	 **/
	public static volatile SingularAttribute<Store, Integer> _id;

}

