package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(UserFollowProduct.class)
public abstract class UserFollowProduct_ {

	public static final String CREATED_AT = "createdAt";
	public static final String PRODUCT = "product";
	public static final String _ID = "_id";
	public static final String QUERY_USER_FOLLOW_PRODUCT_FIND_ALL = "UserFollowProduct.findAll";
	public static final String USER = "user";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.UserFollowProduct#createdAt
	 **/
	public static volatile SingularAttribute<UserFollowProduct, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.UserFollowProduct#product
	 **/
	public static volatile SingularAttribute<UserFollowProduct, Product> product;
	
	/**
	 * @see ute.shop.entity.UserFollowProduct#_id
	 **/
	public static volatile SingularAttribute<UserFollowProduct, Integer> _id;
	
	/**
	 * @see ute.shop.entity.UserFollowProduct
	 **/
	public static volatile EntityType<UserFollowProduct> class_;
	
	/**
	 * @see ute.shop.entity.UserFollowProduct#user
	 **/
	public static volatile SingularAttribute<UserFollowProduct, User> user;
	
	/**
	 * @see ute.shop.entity.UserFollowProduct#updatedAt
	 **/
	public static volatile SingularAttribute<UserFollowProduct, Date> updatedAt;

}

