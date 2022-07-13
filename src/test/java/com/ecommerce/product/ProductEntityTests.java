package com.ecommerce.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.product.model.Products;

@SpringBootTest
public class ProductEntityTests {
@Test
public void get() {
	Products products= new Products();
    products.setId(products.getId());
    products.setCategoryId(products.getCategoryId());
}
}
