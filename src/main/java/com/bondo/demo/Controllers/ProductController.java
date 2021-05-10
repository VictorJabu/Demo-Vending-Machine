package com.bondo.demo.Controllers;

import com.bondo.demo.Model.Product;
import com.bondo.demo.Repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getProducts() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        return productList;
    }

}
