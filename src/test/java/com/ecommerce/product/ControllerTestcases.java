package com.ecommerce.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.product.controller.ProductController;
import com.ecommerce.product.implementation.ProductServiceImplementation;
import com.ecommerce.product.model.Products;
import com.ecommerce.product.service.ProductService;
@SpringBootTest
public class ControllerTestcases {
	@Mock
	ProductService productService = new ProductServiceImplementation();
	@InjectMocks
	ProductController productcontroller;
    @Test   
	@Order(7)
	void test_getProducts() {
	List<Products> product=new ArrayList<Products>();
	product.add(new Products("123abc", "redmi9pro", 12000, 3000,
	"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
	"ram 2gb,internal:16gb,camera:16mp", "123ase"));
	product.add(new Products("983abc", "redmi7pro", 11000, 2000,
	"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
	"ram:2gb,internal:8gb,camera:16mp", "187rda"));
	when(productService.getallcategories()).thenReturn(product);
	ResponseEntity<List<Products>> res=productcontroller.getallcategories();
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody());
	}
    @Test
	@Order(8)
	void test_getProductsById() {
		Products product = new Products("123abc", "redmi9", 10000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
	String id="123hdgf";
	when(productService.readproduct(id)).thenReturn(true);
	when(productService.getProductsbyproductId(id)).thenReturn(product);
	ResponseEntity<Products> res=productcontroller.getByproductId(id);
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody());
	}
}
