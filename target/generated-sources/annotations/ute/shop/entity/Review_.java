package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Review.class)
public abstract class Review_ {

	public static final String CREATED_AT = "createdAt";
	public static final String PRODUCT = "product";
	public static final String _ID = "_id";
	public static final String STORE = "store";
	public static final String STARS = "stars";
	public static final String USER = "user";
	public static final String QUERY_REVIEW_FIND_ALL = "Review.findAll";
	public static final String CONTENT = "content";
	public static final String ORDER = "order";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Review#createdAt
	 **/
	public static volatile SingularAttribute<Review, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Review#product
	 **/
	public static volatile SingularAttribute<Review, Product> product;
	
	/**
	 * @see ute.shop.entity.Review#_id
	 **/
	public static volatile SingularAttribute<Review, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Review#store
	 **/
	public static volatile SingularAttribute<Review, Store> store;
	
	/**
	 * @see ute.shop.entity.Review#stars
	 **/
	public static volatile SingularAttribute<Review, Integer> stars;
	
	/**
	 * @see ute.shop.entity.Review
	 **/
	public static volatile EntityType<Review> class_;
	
	/**
	 * @see ute.shop.entity.Review#user
	 **/
	public static volatile SingularAttribute<Review, User> user;
	
	/**
	 * @see ute.shop.entity.Review#content
	 **/
	public static volatile SingularAttribute<Review, String> content;
	
	/**
	 * @see ute.shop.entity.Review#order
	 **/
	public static volatile SingularAttribute<Review, Order> order;
	
	/**
	 * @see ute.shop.entity.Review#updatedAt
	 **/
	public static volatile SingularAttribute<Review, Date> updatedAt;

}

