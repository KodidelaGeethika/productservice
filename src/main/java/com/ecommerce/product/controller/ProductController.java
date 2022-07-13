package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.model.Products;
import com.ecommerce.product.service.ProductService;

@RestController
	public class ProductController {
	@Autowired
	ProductService productservice;



	@PostMapping("/products")
	public ResponseEntity<Products> create(@RequestBody Products productmodel) {

	return new ResponseEntity<Products>(productservice.createcategory(productmodel), HttpStatus.CREATED);




	}



	@GetMapping("/products")
	public ResponseEntity<List<Products>> getallcategories() {
	
	return new ResponseEntity<List<Products>>(productservice.getallcategories(), HttpStatus.OK);



	
	}



	@PutMapping("/products/{productId}")



	public ResponseEntity<Products> Edit(@PathVariable("productId") String productId,
	@RequestBody Products productmodel) {
	try {
	if (!productservice.readproduct(productId)) {
	throw new IllegalArgumentException("product not found");
	}
	return new ResponseEntity<Products>(productservice.EditProductId(productId, productmodel),
	HttpStatus.CREATED);



	} catch (Exception e) {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);



	}
	}



	@DeleteMapping("/products/{productId}")
	public String create(@PathVariable("productId") String productId) {
	productservice.deleteProductData(productId);
    return "product deleted successfully";


	}



	@GetMapping("/product/{categoryId}")
	public ResponseEntity<List<Products>> getBycategoryId(@PathVariable("categoryId") String categoryId) {
	try {
	if (productservice.getProductsbyCategoryId(categoryId).isEmpty()) {
	throw new IllegalArgumentException("category not found");
	}



	return new ResponseEntity<List<Products>>(productservice.getProductsbyCategoryId(categoryId), HttpStatus.OK);
	} catch (Exception e) {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);



	}
	}



	@GetMapping("/products/{productId}")
	public ResponseEntity<Products> getByproductId(@PathVariable("productId") String productId) {
	try {
	if (!productservice.readproduct(productId)) {
	throw new IllegalArgumentException("product not found");
	}
	



	return new ResponseEntity<Products>(productservice.getProductsbyproductId(productId), HttpStatus.OK);
	} catch (Exception e) {
	return new ResponseEntity<>( HttpStatus.NOT_FOUND);



	}
	}
}
