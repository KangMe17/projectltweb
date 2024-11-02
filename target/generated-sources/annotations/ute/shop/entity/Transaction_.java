package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static final String CREATED_AT = "createdAt";
	public static final String AMOUNT = "amount";
	public static final String QUERY_TRANSACTION_FIND_ALL = "Transaction.findAll";
	public static final String IS_UP = "isUp";
	public static final String _ID = "_id";
	public static final String STORE = "store";
	public static final String USER = "user";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Transaction#createdAt
	 **/
	public static volatile SingularAttribute<Transaction, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Transaction#amount
	 **/
	public static volatile SingularAttribute<Transaction, Double> amount;
	
	/**
	 * @see ute.shop.entity.Transaction#isUp
	 **/
	public static volatile SingularAttribute<Transaction, Boolean> isUp;
	
	/**
	 * @see ute.shop.entity.Transaction#_id
	 **/
	public static volatile SingularAttribute<Transaction, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Transaction#store
	 **/
	public static volatile SingularAttribute<Transaction, Store> store;
	
	/**
	 * @see ute.shop.entity.Transaction
	 **/
	public static volatile EntityType<Transaction> class_;
	
	/**
	 * @see ute.shop.entity.Transaction#user
	 **/
	public static volatile SingularAttribute<Transaction, User> user;
	
	/**
	 * @see ute.shop.entity.Transaction#updatedAt
	 **/
	public static volatile SingularAttribute<Transaction, Date> updatedAt;

}

