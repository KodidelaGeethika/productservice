package com.ecommerce.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.product.controller.ProductController;
import com.ecommerce.product.implementation.ProductServiceImplementation;
import com.ecommerce.product.model.Products;
import com.ecommerce.product.repository.ProductRepository;
@SpringBootTest(classes = { ProductControllerTests.class })
public class ProductControllerTests {
	@Mock
	ProductServiceImplementation productserviceimpl;
	@InjectMocks
	ProductController productcontroller;
    
	@Test

	void test_getProducts() {
		List<Products> product = new ArrayList<Products>();
		product.add(new Products("123abc", "redmi9pro", 12000, 3000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase"));
		product.add(new Products("983abc", "redmi7pro", 11000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram:2gb,internal:8gb,camera:16mp", "187rda"));
		when(productserviceimpl.getallcategories()).thenReturn(product);
		ResponseEntity<List<Products>> res = productcontroller.getallcategories();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(product, res.getBody());
	}

	@Test

	void test_getProductsById() {
		Products product = new Products("123abc", "redmi9", 10000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
	String id="123hdgf";
	when(productserviceimpl.readproduct(id)).thenReturn(true);
	when(productserviceimpl.getProductsbyproductId(id)).thenReturn(product);
	ResponseEntity<Products> res=productcontroller.getByproductId(id);
	assertEquals(HttpStatus.OK,res.getStatusCode());
	assertEquals(product,res.getBody());
	}
	@Test

	void test_EditProductId() {
		Products product = new Products("123abc", "redmi9", 30000, 1000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
	String id="123abc";
	when(productserviceimpl.readproduct(id)).thenReturn(true);
	when(productserviceimpl.EditProductId(id, product)).thenReturn(product);
	ResponseEntity<Products> res=productcontroller.Edit(id,product);
	assertEquals(HttpStatus.CREATED,res.getStatusCode());
	assertEquals(product,res.getBody());

	}
	@Test

	void test_deleteProductData() {
		Products product = new Products("123abc", "redmi9", 10000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
	 String msg = "product deleted successfully";
	 String id ="123abc";
	 productcontroller.create(id);
	assertEquals(msg,productcontroller.create(id));
	}
	
    @Test
	void test_getProductsbyCategoryId() {
		List<Products> product = new ArrayList<Products>();
		product.add(new Products("123abc", "redmi9pro", 12000, 3000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase"));
		product.add(new Products("983abc", "redmi7pro", 11000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram:2gb,internal:8gb,camera:16mp", "187rda"));
		String id = "187rda";
		when(productserviceimpl.getProductsbyCategoryId(id)).thenReturn(product);
		ResponseEntity<List<Products>> res = productcontroller.getBycategoryId(id);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(product, res.getBody());
	
	}
    @Test
    void test_create() {
    	Products product = new Products("123abc", "redmi9", 10000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
		when(productserviceimpl.createcategory(product)).thenReturn(product);

    	ResponseEntity<Products> res=productcontroller.create(product);
    	assertEquals(HttpStatus.CREATED,res.getStatusCode());
    	assertEquals(product,res.getBody());

    }
   
    @Test
	void testEditProductId() {
		Products product = new Products("123abc", "redmi9", 30000, 1000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
	String id="123abc";
	when(productserviceimpl.readproduct(id)).thenReturn(false);
	ResponseEntity<Products> res=productcontroller.Edit(id,product);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());

    }
    @Test

	void testgetProductsById() {
		Products product = new Products("123abc", "redmi9", 10000, 2000,
				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
				"ram 2gb,internal:16gb,camera:16mp", "123ase");
	String id="123hdgf";
	when(productserviceimpl.readproduct(id)).thenReturn(false);
	ResponseEntity<Products> res=productcontroller.getByproductId(id);
	assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
	
	}
    @Test
   	void testgetProductsbyCategoryId() {
   		List<Products> product = new ArrayList<Products>();
   		product.add(new Products("123abc", "redmi9pro", 12000, 3000,
   				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
   				"ram 2gb,internal:16gb,camera:16mp", "123ase"));
   		product.add(new Products("983abc", "redmi7pro", 11000, 2000,
   				"https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcS8fljsMS_VIN21njkrpKvyk0AMK4QLQqIugwP1UVUm1cqWGymOhiaDAPTz6Q7a&usqp=CAc",
   				"ram:2gb,internal:8gb,camera:16mp", "187rda"));
   		String id = "187rda";
   		when(productserviceimpl.readproduct(id)).thenReturn(false);
   		ResponseEntity<List<Products>> res = productcontroller.getBycategoryId(id);
   		assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
   	 	
   	}

}

