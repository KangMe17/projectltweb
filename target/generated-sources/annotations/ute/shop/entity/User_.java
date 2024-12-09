package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import ute.shop.entity.User.Role;

@StaticMetamodel(User.class)
public abstract class User_ {

	public static final String FIRSTNAME = "firstname";
	public static final String ROLE = "role";
	public static final String ID_CARD = "id_card";
	public static final String IS_EMAIL_ACTIVE = "isEmailActive";
	public static final String COVER = "cover";
	public static final String CREATED_AT = "createdAt";
	public static final String PASSWORD = "password";
	public static final String REVIEWS = "reviews";
	public static final String OWNED_STORE = "ownedStore";
	public static final String STAFFED_STORES = "staffedStores";
	public static final String EMAIL = "email";
	public static final String UPDATED_AT = "updatedAt";
	public static final String USER_FOLLOW_STORES = "userFollowStores";
	public static final String ADDRESS = "address";
	public static final String IS_PHONE_ACTIVE = "isPhoneActive";
	public static final String AVATAR = "avatar";
	public static final String TRANSACTIONS = "transactions";
	public static final String USER_FOLLOW_PRODUCTS = "userFollowProducts";
	public static final String LASTNAME = "lastname";
	public static final String E_WALLET = "e_wallet";
	public static final String CARTS = "carts";
	public static final String QUERY_USER_FIND_ALL = "User.findAll";
	public static final String PHONE = "phone";
	public static final String ORDERS = "orders";
	public static final String _ID = "_id";

	
	/**
	 * @see ute.shop.entity.User#firstname
	 **/
	public static volatile SingularAttribute<User, String> firstname;
	
	/**
	 * @see ute.shop.entity.User#role
	 **/
	public static volatile SingularAttribute<User, Role> role;
	
	/**
	 * @see ute.shop.entity.User#id_card
	 **/
	public static volatile SingularAttribute<User, String> id_card;
	
	/**
	 * @see ute.shop.entity.User#isEmailActive
	 **/
	public static volatile SingularAttribute<User, Boolean> isEmailActive;
	
	/**
	 * @see ute.shop.entity.User#cover
	 **/
	public static volatile SingularAttribute<User, String> cover;
	
	/**
	 * @see ute.shop.entity.User#createdAt
	 **/
	public static volatile SingularAttribute<User, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see ute.shop.entity.User#reviews
	 **/
	public static volatile ListAttribute<User, Review> reviews;
	
	/**
	 * @see ute.shop.entity.User#ownedStore
	 **/
	public static volatile SingularAttribute<User, Store> ownedStore;
	
	/**
	 * @see ute.shop.entity.User#staffedStores
	 **/
	public static volatile ListAttribute<User, Store> staffedStores;
	
	/**
	 * @see ute.shop.entity.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see ute.shop.entity.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;
	
	/**
	 * @see ute.shop.entity.User#updatedAt
	 **/
	public static volatile SingularAttribute<User, Date> updatedAt;
	
	/**
	 * @see ute.shop.entity.User#userFollowStores
	 **/
	public static volatile ListAttribute<User, UserFollowStore> userFollowStores;
	
	/**
	 * @see ute.shop.entity.User#address
	 **/
	public static volatile SingularAttribute<User, String> address;
	
	/**
	 * @see ute.shop.entity.User#isPhoneActive
	 **/
	public static volatile SingularAttribute<User, Boolean> isPhoneActive;
	
	/**
	 * @see ute.shop.entity.User#avatar
	 **/
	public static volatile SingularAttribute<User, String> avatar;
	
	/**
	 * @see ute.shop.entity.User#transactions
	 **/
	public static volatile ListAttribute<User, Transaction> transactions;
	
	/**
	 * @see ute.shop.entity.User#userFollowProducts
	 **/
	public static volatile ListAttribute<User, UserFollowProduct> userFollowProducts;
	
	/**
	 * @see ute.shop.entity.User#lastname
	 **/
	public static volatile SingularAttribute<User, String> lastname;
	
	/**
	 * @see ute.shop.entity.User#e_wallet
	 **/
	public static volatile SingularAttribute<User, Double> e_wallet;
	
	/**
	 * @see ute.shop.entity.User#carts
	 **/
	public static volatile ListAttribute<User, Cart> carts;
	
	/**
	 * @see ute.shop.entity.User#phone
	 **/
	public static volatile SingularAttribute<User, String> phone;
	
	/**
	 * @see ute.shop.entity.User#orders
	 **/
	public static volatile ListAttribute<User, Order> orders;
	
	/**
	 * @see ute.shop.entity.User#_id
	 **/
	public static volatile SingularAttribute<User, Integer> _id;

}

