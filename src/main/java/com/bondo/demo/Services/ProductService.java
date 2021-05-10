package com.bondo.demo.Services;

import com.bondo.demo.Model.Product;
import com.bondo.demo.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }


}
