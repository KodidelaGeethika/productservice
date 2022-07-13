package com.ecommerce.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
	public class Products {
	@Id
	private String id;
	private String productName;
	private double regularPrice;
	private double discountPrice;
	private String image;
	private String productdescription;
	private String categoryId;





	public Products(String id, String productName, double regularPrice, double discountPrice, String image,
	String productdescription, String categoryId) {
	super();
	this.id = id;
	this.productName = productName;
	this.regularPrice = regularPrice;
	this.discountPrice = discountPrice;
	this.image = image;
	this.productdescription = productdescription;
	this.categoryId = categoryId;
	}



	public Products() {
		// TODO Auto-generated constructor stub
	}



	public String getId() {
	return id;
	}



	public void setId(String id) {
	this.id = id;
	}



	public String getProductName() {
	return productName;
	}



	public void setProductName(String productName) {
	this.productName = productName;
	}



	public double getRegularPrice() {
	return regularPrice;
	}



	public void setRegularPrice(double regularPrice) {
	this.regularPrice = regularPrice;
	}



	public double getDiscountPrice() {
	return discountPrice;
	}



	public void setDiscountPrice(double discountPrice) {
	this.discountPrice = discountPrice;
	}





	public String getImage() {
	return image;
	}



	public void setImage(String image) {
	this.image = image;
	}



	public String getProductdescription() {
	return productdescription;
	}



	public void setProductdescription(String productdescription) {
	this.productdescription = productdescription;
	}



	public String getCategoryId() {
	return categoryId;
	}



	public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
	}




	}

