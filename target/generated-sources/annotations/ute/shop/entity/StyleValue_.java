package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(StyleValue.class)
public abstract class StyleValue_ {

	public static final String CREATED_AT = "createdAt";
	public static final String QUERY_STYLE_VALUE_FIND_ALL = "StyleValue.findAll";
	public static final String PRODUCT = "product";
	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String STYLE = "style";
	public static final String _ID = "_id";
	public static final String CART_ITEM = "cartItem";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.StyleValue#createdAt
	 **/
	public static volatile SingularAttribute<StyleValue, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.StyleValue#product
	 **/
	public static volatile SingularAttribute<StyleValue, Product> product;
	
	/**
	 * @see ute.shop.entity.StyleValue#isDeleted
	 **/
	public static volatile SingularAttribute<StyleValue, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.StyleValue#name
	 **/
	public static volatile SingularAttribute<StyleValue, String> name;
	
	/**
	 * @see ute.shop.entity.StyleValue#style
	 **/
	public static volatile SingularAttribute<StyleValue, Style> style;
	
	/**
	 * @see ute.shop.entity.StyleValue#_id
	 **/
	public static volatile SingularAttribute<StyleValue, Integer> _id;
	
	/**
	 * @see ute.shop.entity.StyleValue
	 **/
	public static volatile EntityType<StyleValue> class_;
	
	/**
	 * @see ute.shop.entity.StyleValue#cartItem
	 **/
	public static volatile SingularAttribute<StyleValue, CartItem> cartItem;
	
	/**
	 * @see ute.shop.entity.StyleValue#updatedAt
	 **/
	public static volatile SingularAttribute<StyleValue, Date> updatedAt;

}

