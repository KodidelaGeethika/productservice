package com.ecommerce.product.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.model.Products;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductService;

@Service
	public class ProductServiceImplementation implements ProductService {
	@Autowired
	ProductRepository productrepository;



	public Products createcategory(Products products) {
	return productrepository.save(products);
	}



	public List<Products> getallcategories() {
	return productrepository.findAll();
	}



	public Products EditProductId(String id, Products newproduct) {
	Optional<Products> data = productrepository.findById(id);
	Products productmodel = data.get();
	productmodel.setProductName(newproduct.getProductName());
	productmodel.setRegularPrice(newproduct.getRegularPrice());
	productmodel.setDiscountPrice(newproduct.getDiscountPrice());
	productmodel.setProductdescription(newproduct.getProductdescription());
	productmodel.setImage(newproduct.getImage());
	return productrepository.save(productmodel);
	}



	public void deleteProductData(String id) {
	productrepository.deleteById(id);
	}
	public List<Products> getProductsbyCategoryId(String categoryId){
	return productrepository.findBycategoryId(categoryId);
	}
	public Products getProductsbyproductId(String id) {
	Optional<Products> data = productrepository.findById(id);
	return data.get();
	}
	public boolean readproduct(String id) {
	return productrepository.findById(id).isPresent();
	}


}
