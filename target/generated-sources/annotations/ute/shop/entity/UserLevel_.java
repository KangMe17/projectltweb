package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(UserLevel.class)
public abstract class UserLevel_ {

	public static final String MIN_POINT = "minPoint";
	public static final String CREATED_AT = "createdAt";
	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String QUERY_USER_LEVEL_FIND_ALL = "UserLevel.findAll";
	public static final String DISCOUNT = "discount";
	public static final String _ID = "_id";
	public static final String USERS = "users";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.UserLevel#minPoint
	 **/
	public static volatile SingularAttribute<UserLevel, Integer> minPoint;
	
	/**
	 * @see ute.shop.entity.UserLevel#createdAt
	 **/
	public static volatile SingularAttribute<UserLevel, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.UserLevel#isDeleted
	 **/
	public static volatile SingularAttribute<UserLevel, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.UserLevel#name
	 **/
	public static volatile SingularAttribute<UserLevel, String> name;
	
	/**
	 * @see ute.shop.entity.UserLevel#discount
	 **/
	public static volatile SingularAttribute<UserLevel, Double> discount;
	
	/**
	 * @see ute.shop.entity.UserLevel#_id
	 **/
	public static volatile SingularAttribute<UserLevel, Integer> _id;
	
	/**
	 * @see ute.shop.entity.UserLevel
	 **/
	public static volatile EntityType<UserLevel> class_;
	
	/**
	 * @see ute.shop.entity.UserLevel#users
	 **/
	public static volatile ListAttribute<UserLevel, User> users;
	
	/**
	 * @see ute.shop.entity.UserLevel#updatedAt
	 **/
	public static volatile SingularAttribute<UserLevel, Date> updatedAt;

}

