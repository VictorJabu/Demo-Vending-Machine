package com.bondo.demo.Repository;

import com.bondo.demo.Model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testRepositoryCanPullProducts(){
        List<Product> products = (List<Product>) productRepository.findAll();
        assertNotNull(products);
    }

    @Test
    public void testObjectIsOfTypeProduct(){

        Optional<Product> optionalProduct = productRepository.findById(1L);
        assertThat(optionalProduct).isPresent()
                .containsInstanceOf(Product.class);
    }
}
