package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(UserFollowStore.class)
public abstract class UserFollowStore_ {

	public static final String CREATED_AT = "createdAt";
	public static final String QUERY_USER_FOLLOW_STORE_FIND_ALL = "UserFollowStore.findAll";
	public static final String _ID = "_id";
	public static final String STORE = "store";
	public static final String USER = "user";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.UserFollowStore#createdAt
	 **/
	public static volatile SingularAttribute<UserFollowStore, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.UserFollowStore#_id
	 **/
	public static volatile SingularAttribute<UserFollowStore, Integer> _id;
	
	/**
	 * @see ute.shop.entity.UserFollowStore#store
	 **/
	public static volatile SingularAttribute<UserFollowStore, Store> store;
	
	/**
	 * @see ute.shop.entity.UserFollowStore
	 **/
	public static volatile EntityType<UserFollowStore> class_;
	
	/**
	 * @see ute.shop.entity.UserFollowStore#user
	 **/
	public static volatile SingularAttribute<UserFollowStore, User> user;
	
	/**
	 * @see ute.shop.entity.UserFollowStore#updatedAt
	 **/
	public static volatile SingularAttribute<UserFollowStore, Date> updatedAt;

}

