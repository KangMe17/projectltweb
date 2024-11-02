package ute.shop.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static final String IMAGE = "image";
	public static final String SUB_CATEGORIES = "subCategories";
	public static final String PRODUCTS = "products";
	public static final String CREATED_AT = "createdAt";
	public static final String IS_DELETED = "isDeleted";
	public static final String QUERY_CATEGORY_FIND_ALL = "Category.findAll";
	public static final String NAME = "name";
	public static final String PARENT_CATEGORY = "parentCategory";
	public static final String STYLES = "styles";
	public static final String _ID = "_id";
	public static final String SLUG = "slug";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see ute.shop.entity.Category#image
	 **/
	public static volatile SingularAttribute<Category, String> image;
	
	/**
	 * @see ute.shop.entity.Category#subCategories
	 **/
	public static volatile ListAttribute<Category, Category> subCategories;
	
	/**
	 * @see ute.shop.entity.Category#products
	 **/
	public static volatile ListAttribute<Category, Product> products;
	
	/**
	 * @see ute.shop.entity.Category#createdAt
	 **/
	public static volatile SingularAttribute<Category, Date> createdAt;
	
	/**
	 * @see ute.shop.entity.Category#isDeleted
	 **/
	public static volatile SingularAttribute<Category, Boolean> isDeleted;
	
	/**
	 * @see ute.shop.entity.Category#name
	 **/
	public static volatile SingularAttribute<Category, String> name;
	
	/**
	 * @see ute.shop.entity.Category#parentCategory
	 **/
	public static volatile SingularAttribute<Category, Category> parentCategory;
	
	/**
	 * @see ute.shop.entity.Category#styles
	 **/
	public static volatile ListAttribute<Category, Style> styles;
	
	/**
	 * @see ute.shop.entity.Category#_id
	 **/
	public static volatile SingularAttribute<Category, Integer> _id;
	
	/**
	 * @see ute.shop.entity.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see ute.shop.entity.Category#slug
	 **/
	public static volatile SingularAttribute<Category, String> slug;
	
	/**
	 * @see ute.shop.entity.Category#updatedAt
	 **/
	public static volatile SingularAttribute<Category, Date> updatedAt;

}

