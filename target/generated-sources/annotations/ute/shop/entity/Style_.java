package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Style.class)
public abstract class Style_ {

	public static final String CREATED_AT = "createdAt";
	public static final String CATEGORY_IDS = "categoryIds";
	public static final String IS_DELETED = "isDeleted";
	public static final String NAME = "name";
	public static final String STYLE_VALUES = "styleValues";
	public static final String ID = "id";
	public static final String CATEGORIES = "categories";
	public static final String QUERY_STYLE_FIND_ALL = "Style.findAll";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Style#createdAt
	 **/
	public static volatile SingularAttribute<Style, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Style#categoryIds
	 **/
	public static volatile ListAttribute<Style, String> categoryIds;
	
	/**
	 * @see ute.shop.entity.Style#isDeleted
	 **/
	public static volatile SingularAttribute<Style, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.Style#name
	 **/
	public static volatile SingularAttribute<Style, String> name;
	
	/**
	 * @see ute.shop.entity.Style#styleValues
	 **/
	public static volatile ListAttribute<Style, StyleValue> styleValues;
	
	/**
	 * @see ute.shop.entity.Style#id
	 **/
	public static volatile SingularAttribute<Style, Integer> id;
	
	/**
	 * @see ute.shop.entity.Style#categories
	 **/
	public static volatile ListAttribute<Style, Category> categories;
	
	/**
	 * @see ute.shop.entity.Style
	 **/
	public static volatile EntityType<Style> class_;
	
	/**
	 * @see ute.shop.entity.Style#updatedAt
	 **/
	public static volatile SingularAttribute<Style, Date> updatedAt;

}

